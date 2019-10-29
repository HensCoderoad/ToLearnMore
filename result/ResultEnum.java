package com.shiro.jpa.defineexception;

public enum ResultEnum {
    SUCCESS(0,"success"),
    FAIL(1,"fail");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    public static String getMessage(String name){
        for(ResultEnum resultEnum : ResultEnum.values()){
            if(resultEnum.name().equals(name)){
                return resultEnum.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name){
        for (ResultEnum resultEnum : ResultEnum.values()){
            if (resultEnum.name().equals(name)){
                return resultEnum.code;
            }
        }
        return null;
    }
}
