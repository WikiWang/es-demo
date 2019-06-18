package com.example.es.demo.exception;

import com.example.es.demo.exception.error.ErrorDefine;

/**
 * ClassName: BaseSystemException
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:53
 */
public abstract class BaseSystemException extends Exception{

    /**
     *  description: get error define
     *  @param: []
     *  @return: ErrorDefine
     *
     *  @author: wk
     *  @date: 2019-04-30 14:15
     */
    public abstract ErrorDefine getErrorDefine();

    /**
     *  description: get http status
     *  @param: []
     *  @return: int
     *
     *  @author: wk
     *  @date: 2019-04-30 14:16
     */
    public abstract int getHttpStatus();

    public BaseSystemException(){
        super();
    }
    public BaseSystemException(String message){
        super(message);
    }
    public BaseSystemException(String message, Throwable cause) {
        super(message, cause);
    }
    public BaseSystemException(Throwable cause) {
        super(cause);
    }
}
