package com.sdjz.cqbms.aop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * JsonResult 格式返回值注解
 * @version 1.0
 * @className JsonResultController
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
@Controller
public @interface JsonResultController {

    /**
     * 是否自动将结果封装为：JsonResult对象。
     * 默认：true
     * @return
     */
    boolean autoWrap() default true;

}

