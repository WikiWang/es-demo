package com.example.es.demo.exception;

/**
 * ClassName: SerializeRuntimeException
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 11:01
 */
public class SerializeRuntimeException extends RuntimeException  {

    /**
     *  description: Creates a new instance of SerializeRuntimeException.
     *  @param: [message 异常描述信息, cause]
     *
     *  @author wk
     *  @date 2019-04-29 16:42
     */
    public SerializeRuntimeException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     *  description: Creates a new instance of SerializeRuntimeException.
     *  @param: [cause]
     *
     *  @author wk
     *  @date 2019-04-29 16:49
     */
    public SerializeRuntimeException(Throwable cause){
        super(cause);
    }
}
