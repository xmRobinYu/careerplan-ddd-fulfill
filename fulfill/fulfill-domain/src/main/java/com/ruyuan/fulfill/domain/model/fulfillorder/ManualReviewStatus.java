package com.ruyuan.fulfill.domain.model.fulfillorder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 人工审核状态
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public enum ManualReviewStatus {

    UN_PASS(10, "未通过"),
    PASSED(20, "已通过"),
    ;


    private Integer code;

    private String msg;

    ManualReviewStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static Map<Integer, String> toMap() {
        Map<Integer, String> map = new HashMap<>(16);
        for (ManualReviewStatus element : ManualReviewStatus.values()) {
            map.put(element.getCode(), element.getMsg());
        }
        return map;
    }

    public static ManualReviewStatus getByCode(Integer code) {
        for (ManualReviewStatus element : ManualReviewStatus.values()) {
            if (code.equals(element.getCode())) {
                return element;
            }
        }
        return null;
    }

    public static Set<Integer> allowableValues() {
        Set<Integer> allowableValues = new HashSet<>(values().length);
        for (ManualReviewStatus orderStatusEnum : values()) {
            allowableValues.add(orderStatusEnum.getCode());
        }
        return allowableValues;
    }
}