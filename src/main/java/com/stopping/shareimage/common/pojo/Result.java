package com.stopping.shareimage.common.pojo;

import lombok.Data;

@Data
public class Result<T> {

    private String msg;

    private Integer code;

    private T data;
}
