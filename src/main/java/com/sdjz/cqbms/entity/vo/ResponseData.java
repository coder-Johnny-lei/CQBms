package com.sdjz.cqbms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class ResponseData implements Serializable {

    private String code;

    private String message;

    private Object data;


}
