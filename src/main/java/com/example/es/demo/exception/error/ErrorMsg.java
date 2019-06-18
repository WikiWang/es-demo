package com.example.es.demo.exception.error;

/**
 * ClassName: ErrorMsg
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:47
 */
public class ErrorMsg {

    private String errorType;
    private String errorCode;
    private String errorDescription;
    private String errorDetail;
    private String path;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorType+"-"+errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String despcription) {
        this.errorDescription = despcription;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

}
