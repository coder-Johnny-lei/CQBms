package com.sdjz.cqbms.exception;

/**
 * 业务异常通用类
 * @version 1.0
 * @className BusinessException
 * @description
 */
public class BusinessException extends RuntimeException {

    /**
     * 构造方法
     * @param message
     * @return BusinessException
     */
    public BusinessException(String message) {
        super(message);
    }

}
