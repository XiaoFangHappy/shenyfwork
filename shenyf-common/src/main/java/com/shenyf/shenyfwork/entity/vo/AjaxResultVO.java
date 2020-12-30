package com.shenyf.shenyfwork.entity.vo;

import com.shenyf.shenyfwork.constant.ErrorTypeEnum;
import lombok.Data;

/**
 * @Description
 * @Author wenzh
 * @Date Created in 2020/5/12 14:10
 */
@Data
public class AjaxResultVO<T> {

    private String code;
    private String message;
    private T data;

    /**
     * 返回成功（无返回参数）
     * @return
     */
    public static AjaxResultVO markSuccess(){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(ErrorTypeEnum.SUCCESS.getCode());
        return bean;
    }

    /**
     * 返回成功（有返回参数）
     * @return
     */
    public static AjaxResultVO markSuccess(Object object){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(ErrorTypeEnum.SUCCESS.getCode());
        bean.setData(object);
        return bean;
    }
    /**
     * 返回成功（有返回参数）
     * @return
     */
    public static AjaxResultVO markSuccessCode(String code,Object object){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(code);
        bean.setData(object);
        return bean;
    }


    /**
     * 返回成功（有描述和返回参数）
     * @param msg
     * @param object
     * @return
     */
    public static AjaxResultVO markSuccess(String msg, Object object){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(ErrorTypeEnum.SUCCESS.getCode());
        bean.setMessage(msg);
        bean.setData(object);
        return bean;
    }
    /**
     * 返回成功（有描述和返回参数）
     * @param msg
     * @param object
     * @return
     */
    public static AjaxResultVO markSuccess(String code ,String msg, Object object){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(code);
        bean.setMessage(msg);
        bean.setData(object);
        return bean;
    }

    /**
     * 返回失败
     * @param msg
     * @return
     */
    public static AjaxResultVO markError(String msg){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(ErrorTypeEnum.ERROR.getCode());
        bean.setMessage(msg);
        return bean;
    }
    /**
     * 返回失败
     * @param code
     * @param msg
     * @return
     */
    public static AjaxResultVO markError(String code, String msg){
        AjaxResultVO bean = new AjaxResultVO();
        bean.setCode(code);
        bean.setMessage(msg);
        return bean;
    }

}
