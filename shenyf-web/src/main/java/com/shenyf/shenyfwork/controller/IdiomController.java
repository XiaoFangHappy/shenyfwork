package com.shenyf.shenyfwork.controller;

import com.shenyf.shenyfwork.client.HttpClientUtil;
import com.shenyf.shenyfwork.entity.vo.AjaxResultVO;
import com.shenyf.shenyfwork.entity.vo.IdiomRecordVO;
import com.shenyf.shenyfwork.model.IdiomRecord;
import com.shenyf.shenyfwork.service.ITIdiomService;
import com.shenyf.shenyfwork.utils.ChineseUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description:
 * @Author: shenyf
 * @Date: 2020/9/29 13:24
 */
@Slf4j
@Controller
@RequestMapping(value = "/idiom")
public class IdiomController {

    @Autowired
    private ITIdiomService itIdiomService;

    private final static String idiomDetailUrl = "https://api.jisuapi.com/chengyu/detail?appkey=c443963719ef888a&chengyu=";
    private final static String idiomSearchUrl = "https://api.jisuapi.com/chengyu/search?appkey=c443963719ef888a&keyword=";

    @ResponseBody
    @PostMapping("/detail")
    public AjaxResultVO detail(String idiomName) {
        //TODO 校验 idiomName 是否中文
        if (idiomName != null && ChineseUtils.isContainChinese(idiomName)) {
            JSONObject result = getIdiomDetail(idiomName);
            if (result != null) {
                return AjaxResultVO.markSuccess("查询成功", result);
            }
        }
        return AjaxResultVO.markError("查询失败");
    }

    @ResponseBody
    @PostMapping("/search")
    public AjaxResultVO search(String keyword) {
        //TODO 校验 idiomName 是否中文
        if (keyword != null && ChineseUtils.isContainChinese(keyword)) {
            String result = getIdiomSearch(keyword);
            if (StringUtils.isNotBlank(result)) {
                return AjaxResultVO.markSuccess("查询成功", result);
            }
        }
        return AjaxResultVO.markError("查询失败");
    }

    /**
     * 查询成语 并入库
     * @param keyword
     * @return
     */
    private String getIdiomSearch(String keyword) {
        IdiomRecordVO itIdiom = itIdiomService.getIdiomBykeyword(keyword);
        if (itIdiom != null) {
            return itIdiom.getIdiomName();
        } else {
            JSONObject resultJson = HttpClientUtil.httpGet(idiomSearchUrl + keyword);
            if (resultJson != null && resultJson.get("status") != null && StringUtils.equals(resultJson.get("status").toString(), "0") && resultJson.get("result") != null) {
                JSONArray jsonArray = JSONArray.fromObject(resultJson.get("result"));
                log.info("jsonArray:" + jsonArray.toString());
                if(jsonArray != null && !jsonArray.isEmpty()){
                    for(int i = 0;i<jsonArray.size();i++){
                        if(JSONObject.fromObject(jsonArray.get(i)).get("name") != null){
                            String name = (String) JSONObject.fromObject(jsonArray.get(i)).get("name");
                            if(StringUtils.equals(name.substring(0,1),keyword)){
                                return name;
                            }
                        }
                    }
                }
                return null;
            }
            return null;
        }
    }
    /**
     * 成语接龙 先查库再调杰阔
     * @param idiomName
     * @return
     */
    private JSONObject getIdiomDetail(String idiomName) {
        IdiomRecordVO itIdiom = itIdiomService.getIdiomByName(idiomName);
        if (itIdiom != null) {
            JSONObject result = new JSONObject();
            result.accumulate("name", itIdiom.getIdiomName());
            result.accumulate("pronounce", StringUtils.isNotBlank(itIdiom.getIdiomPronounce())?itIdiom.getIdiomPronounce():"");
            result.accumulate("content", StringUtils.isNotBlank(itIdiom.getIdiomContent())?itIdiom.getIdiomContent():"");
            result.accumulate("comefrom", StringUtils.isNotBlank(itIdiom.getIdiomComefrom())?itIdiom.getIdiomComefrom():"");
            result.accumulate("antonym", StringUtils.isNotBlank(itIdiom.getIdiomAntonym())?itIdiom.getIdiomAntonym():"");
            result.accumulate("thesaurus", StringUtils.isNotBlank(itIdiom.getIdiomThesaurus())?itIdiom.getIdiomThesaurus():"");
            result.accumulate("example", StringUtils.isNotBlank(itIdiom.getIdiomExample())?itIdiom.getIdiomExample():"");
            return result;
        } else {
            JSONObject resultJson = HttpClientUtil.httpGet(idiomDetailUrl + idiomName);
            if (resultJson != null && resultJson.get("status") != null && StringUtils.equals(resultJson.get("status").toString(), "0") && resultJson.get("result") != null) {
                JSONObject result = JSONObject.fromObject(resultJson.get("result"));
                log.info("result:" + result);
                IdiomRecord idiomRecord = new IdiomRecord();
                idiomRecord.setIdiomName((String) result.get("name"));
                idiomRecord.setIdiomPronounce(result.get("pronounce") != null ? result.get("pronounce").toString():"");
                idiomRecord.setIdiomContent(result.get("content") != null ? result.get("content").toString():"");
                idiomRecord.setIdiomComefrom(result.get("comefrom") != null ? result.get("comefrom").toString():"");
                idiomRecord.setIdiomAntonym(result.get("antonym") != null ?result.get("antonym").toString():"");
                idiomRecord.setIdiomThesaurus(result.get("thesaurus") != null ?result.get("thesaurus").toString():"");
                idiomRecord.setIdiomExample(result.get("example") != null ? result.get("example").toString():"");
                idiomRecord.setCreateTime(new Date());
                itIdiomService.saveIdiom(idiomRecord);
                return result;
            }
            return null;
        }
    }
}
