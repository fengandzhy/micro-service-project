package org.frank.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.frank.utils.JsonData;
import org.frank.exceptions.BizException;

@Slf4j
@ControllerAdvice
public class CustomerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)    
    public JsonData Handler(Exception e) {

        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            log.info("[业务异常]{}", e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMessage());
        } else {
            log.info("[系统异常]{}", e);
            return JsonData.buildError("全局异常，未知错误");
        }

    }
}
