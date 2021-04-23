package com.shenyf.shenyfwork.controller;

import com.shenyf.shenyfwork.client.HttpClientUtil;
import com.shenyf.shenyfwork.entity.vo.AjaxResultVO;
import com.shenyf.shenyfwork.entity.vo.IdiomRecordVO;
import com.shenyf.shenyfwork.model.IdiomRecord;
import com.shenyf.shenyfwork.service.ITIdiomService;
import com.shenyf.shenyfwork.utils.BeanCopierUtils;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

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
    public AjaxResultVO detail(IdiomRecord idiomRecord) {
        //TODO 校验 idiomName 是否中文
        if (idiomRecord != null && ChineseUtils.isContainChinese(idiomRecord.getIdiomName())) {
            IdiomRecordVO result = getIdiomDetail(idiomRecord.getIdiomName());
            if (result != null) {
                return AjaxResultVO.markSuccess("查询成功", result);
            }
        }
        return AjaxResultVO.markError("查询失败");
    }

    @ResponseBody
    @PostMapping("/search")
    public AjaxResultVO search(Map<String,String> map) {
        //TODO 校验 idiomName 是否中文
        if (map != null && map.get("keyword") != null && ChineseUtils.isContainChinese(map.get("keyword"))) {
            String result = getIdiomSearch(map.get("keyword"));
            if (StringUtils.isNotBlank(result)) {
                return AjaxResultVO.markSuccess("查询成功", result);
            }
        }
        return AjaxResultVO.markError("查询失败");
    }

    @ResponseBody
    @PostMapping("/roundIdiom")
    public AjaxResultVO roundIdiom() {
        //TODO 校验 idiomName 是否中文
        String idiomName = itIdiomService.getIdiomRound();
        if(StringUtils.isNotBlank(idiomName)){
            return AjaxResultVO.markSuccess("成功",idiomName);
        }
        return AjaxResultVO.markError("查询失败");
    }

    @ResponseBody
    @PostMapping("/userAnswer")
    public AjaxResultVO userAnswer(HttpServletRequest request) {
        String idiom = request.getParameter("idiom");
        if (StringUtils.isNotBlank(idiom) && ChineseUtils.isContainChinese(idiom)) {
            IdiomRecordVO result = getIdiomDetail(idiom);
            if (result != null) {
                //查询电脑答案
                String key = result.getIdiomName().substring(result.getIdiomName().length()-1, result.getIdiomName().length());
                String computerAnswer = getIdiomSearch(key);
                if (StringUtils.isNotBlank(computerAnswer)) {
                    return AjaxResultVO.markSuccess("查询成功", computerAnswer);
                }
                return AjaxResultVO.markError("9001","恭喜用户赢了");
            }
        }
        return AjaxResultVO.markError("查询失败");
    }

    /**
     * 查询成语 并入库
     *
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
                if (jsonArray != null && !jsonArray.isEmpty()) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        if (JSONObject.fromObject(jsonArray.get(i)).get("name") != null) {
                            String name = (String) JSONObject.fromObject(jsonArray.get(i)).get("name");
                           /* if (StringUtils.equals(name.substring(0, 1), keyword)) {
                            }*/
                            return name;
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
     *
     * @param idiomName
     * @return
     */
    private IdiomRecordVO getIdiomDetail(String idiomName) {
        IdiomRecordVO itIdiom = itIdiomService.getIdiomByName(idiomName);
        if (itIdiom != null) {
            return itIdiom;
        } else {
            JSONObject resultJson = HttpClientUtil.httpGet(idiomDetailUrl + idiomName);
            if (resultJson != null && resultJson.get("status") != null && StringUtils.equals(resultJson.get("status").toString(), "0") && resultJson.get("result") != null) {
                JSONObject result = JSONObject.fromObject(resultJson.get("result"));
                log.info("result:" + result);
                IdiomRecord idiomRecord = new IdiomRecord();
                idiomRecord.setIdiomName((String) result.get("name"));
                idiomRecord.setIdiomPronounce((result.get("pronounce") != null && !StringUtils.equals("null", result.get("pronounce").toString())) ? result.get("pronounce").toString() : "");
                idiomRecord.setIdiomContent(result.get("content") != null && !StringUtils.equals("null", result.get("content").toString()) ? result.get("content").toString() : "");
                idiomRecord.setIdiomComefrom(result.get("comefrom") != null && !StringUtils.equals("null", result.get("comefrom").toString()) ? result.get("comefrom").toString() : "");
                idiomRecord.setIdiomAntonym(result.get("antonym") != null && !StringUtils.equals("null", result.get("antonym").toString()) ? result.get("antonym").toString() : "");
                idiomRecord.setIdiomThesaurus(result.get("thesaurus") != null && !StringUtils.equals("null", result.get("thesaurus").toString()) ? result.get("thesaurus").toString() : "");
                idiomRecord.setIdiomExample(result.get("example") != null && !StringUtils.equals("null", result.get("example").toString()) ? result.get("example").toString() : "");
                idiomRecord.setCreateTime(new Date());
                itIdiomService.saveIdiom(idiomRecord);
                return BeanCopierUtils.convert(idiomRecord, IdiomRecordVO.class);
            }
            return null;
        }
    }
}
