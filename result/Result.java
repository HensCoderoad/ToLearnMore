package com.shiro.jpa.defineexception;

import java.io.Serializable;

/**
 * 使用Result.failure(ResultEnum.FAIL)
 */
public class Result implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    /**
     * 成功无数据传入
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS);
        return result;
    }

    /**
     * 成功返回数据
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败
     * @param resultEnum
     * @return
     */
    public static Result failure(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum);
        return result;
    }

    /**
     * 失败有返回值
     * @param resultEnum
     * @param object
     * @return
     */
    public static Result failure(ResultEnum resultEnum, Object object){
        Result result = new Result();
        result.setCode(resultEnum);
        result.setData(object);
        return result;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final ResultEnum code) {
        this.code = code.code();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(final Object data) {
        this.data = data;
    }

}
