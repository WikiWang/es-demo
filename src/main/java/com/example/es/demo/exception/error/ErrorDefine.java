package com.example.es.demo.exception.error;

/**
 * ClassName: ErrorDefine
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:46
 */
public enum  ErrorDefine {

    //
    FORMAT_ERROR(ErrorType.GENERIC,"10001","Format error"),
    MESSAGE_NOT_FOUND_ERROR(ErrorType.GENERIC,"10002","Message not found"),

    UNEXPECTED_ERROR(ErrorType.UNEXPECTED,"88888","Unexpected Error"),
    SYSTEM_INTERNAL_ERROR(ErrorType.SYSTEM,"99999","System Internal Error");

    private String type;
    private String code;
    private String description;

    private ErrorDefine(String type, String code, String description){
        this.type=type;
        this.code=code;
        this.description=description;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
