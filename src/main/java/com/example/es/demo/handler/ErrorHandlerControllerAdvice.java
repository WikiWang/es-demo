package com.example.es.demo.handler;

import com.example.es.demo.exception.BaseClientException;
import com.example.es.demo.exception.BaseSystemException;
import com.example.es.demo.exception.error.ErrorDefine;
import com.example.es.demo.exception.error.ErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ErrorHandlerControllerAdvice
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:44
 */
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(BaseClientException.class)
    @ResponseBody
    ErrorMsg handleException(BaseClientException exception, HttpServletRequest request, HttpServletResponse response){
        LOGGER.error("Client error: " + exception.getErrorDefine().getDescription());
        ErrorMsg msg = new ErrorMsg();
        msg.setErrorType(exception.getErrorDefine().getType());
        msg.setErrorCode(exception.getErrorDefine().getCode());
        msg.setErrorDescription(exception.getErrorDefine().getDescription());
        msg.setErrorDetail(exception.getMessage());
        msg.setPath(request.getRequestURI());
        response.setStatus(exception.getHttpStatus());
        return msg;
    }

    @ExceptionHandler(BaseSystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorMsg handleException(BaseSystemException exception,HttpServletRequest request){
        LOGGER.error("System internal exception: ", exception.getMessage());
        ErrorMsg msg = new ErrorMsg();
        msg.setErrorType(ErrorDefine.SYSTEM_INTERNAL_ERROR.getType());
        msg.setErrorCode(ErrorDefine.SYSTEM_INTERNAL_ERROR.getCode());
        msg.setErrorDescription(ErrorDefine.SYSTEM_INTERNAL_ERROR.getDescription());
        msg.setPath(request.getRequestURI());
        return msg;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorMsg handleException(Exception exception,HttpServletRequest request){
        LOGGER.error("System internal unexpected exception: ", exception.getMessage());
        ErrorMsg msg = new ErrorMsg();
        msg.setErrorType(ErrorDefine.UNEXPECTED_ERROR.getType());
        msg.setErrorCode(ErrorDefine.UNEXPECTED_ERROR.getCode());
        msg.setErrorDescription(ErrorDefine.UNEXPECTED_ERROR.getDescription());
        msg.setPath(request.getRequestURI());
        return msg;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerControllerAdvice.class);

}
