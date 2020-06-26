package com.imooc.ad.index;

import lombok.Getter;

@Getter
public enum CommonStatus {

    VALID(1, "Valid status"),
    INVALID(2, "Invalid status");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
