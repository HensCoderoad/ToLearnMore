package com.shiro.jpa.defineexception;

/**
 *自定义异常类
 */
public class DefineException extends Exception {
    private DefineEnum defineEnum;

    private String message;

    public DefineException(DefineEnum defineEnum, String message) {
        super(message);
        this.defineEnum = defineEnum;
        this.message = message;
    }


    public DefineException(String message, Throwable cause, DefineEnum defineEnum) {
        super(message, cause);
        this.defineEnum = defineEnum;
        this.message = message;
    }

    public DefineException(DefineEnum defineEnum) {
        this.defineEnum = defineEnum;
    }

    public DefineEnum getDefineEnum() {
        return defineEnum;
    }

    public void setDefineEnum(DefineEnum defineEnum) {
        this.defineEnum = defineEnum;
    }


}
