package org.frank.exceptions;

import lombok.Data;
import org.frank.enums.BizCodeEnum;

@Data
public class BizException extends RuntimeException{

    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(BizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.message = bizCodeEnum.getMessage();
    }
}
