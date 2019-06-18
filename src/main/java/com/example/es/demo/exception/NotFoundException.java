package com.example.es.demo.exception;

import com.example.es.demo.exception.error.ErrorDefine;
import org.springframework.http.HttpStatus;

/**
 * ClassName: NotFoundException
 * Description: TODO
 *
 * @author wk
 * @date 2019-06-18 10:45
 */
public class NotFoundException extends BaseClientException{

    private ErrorDefine errorDefine;

    public NotFoundException(ErrorDefine errorDefine) {
        this.errorDefine = errorDefine;
    }

    @Override
    public ErrorDefine getErrorDefine() {
        return errorDefine;
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.NOT_FOUND.value();
    }
}
