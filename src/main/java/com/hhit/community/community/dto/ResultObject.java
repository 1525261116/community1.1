package com.hhit.community.community.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/10/14 19:36
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Data
public class ResultObject implements Serializable {
    private static final long serialVersionUID = -856924038217431339L;
    private Integer state = 1;
    private String message;
    private Object Data;

    public ResultObject(String message) {
        this.message = message;
    }

    public ResultObject(Object data) {
        Data = data;
    }

    public ResultObject(Throwable throwable) {
        state = 0;
        this.message = throwable.getMessage();
    }
}
