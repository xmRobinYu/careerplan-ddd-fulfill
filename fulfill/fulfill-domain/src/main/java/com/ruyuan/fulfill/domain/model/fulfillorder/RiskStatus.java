package com.ruyuan.fulfill.domain.model.fulfillorder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 风控审核状态
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public enum RiskStatus {

    UN_PASS(10, "未通过"),
    PASSED(20, "已通过"),
    ;


    private Integer code;

    private String msg;

    RiskStatus(Integer code, String msg) {
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
        for (RiskStatus element : RiskStatus.values()) {
            map.put(element.getCode(), element.getMsg());
        }
        return map;
    }

    public static RiskStatus getByCode(Integer code) {
        for (RiskStatus element : RiskStatus.values()) {
            if (code.equals(element.getCode())) {
                return element;
            }
        }
        return null;
    }

    public static Set<Integer> allowableValues() {
        Set<Integer> allowableValues = new HashSet<>(values().length);
        for (RiskStatus orderStatusEnum : values()) {
            allowableValues.add(orderStatusEnum.getCode());
        }
        return allowableValues;
    }
}