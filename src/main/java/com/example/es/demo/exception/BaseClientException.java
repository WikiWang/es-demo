package com.example.es.demo.exception;

import com.example.es.demo.exception.error.ErrorDefine;

/**
 * ClassName: BaseClientException
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:51
 */
public abstract class BaseClientException extends Exception{

    /**
     *  description: get error define
     *  @param: []
     *  @return: ErrorDefine
     *
     *  @author: wk
     *  @date: 2019-04-30 14:06
     */
    public abstract ErrorDefine getErrorDefine();

    /**
     *  description: get http status
     *  @param: []
     *  @return: int
     *
     *  @author: wk
     *  @date: 2019-04-30 14:15
     */
    public abstract int getHttpStatus();

    public BaseClientException(){
        super();
    }
    public BaseClientException(String message){
        super(message);
    }
    public BaseClientException(String message, Throwable cause) {
        super(message, cause);
    }
    public BaseClientException(Throwable cause) {
        super(cause);
    }
}
