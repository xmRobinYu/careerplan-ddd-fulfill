package com.ruyuan.fulfill.domain.model.fulfillorder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 履约单状态
 *
 * @author zhonghuashishan
 * @version 1.0
 */
public enum FulfillOrderStatus {

    NULL(0, "未知"),
    FULFILL(10, "已创建"),
    WAREHOUSED(20, "已分仓"),
    LOGISTICS(30, "分物流"),
    IN_STORED(40, "下库房"),
    ;


    private Integer code;

    private String msg;

    FulfillOrderStatus(Integer code, String msg) {
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
        for (FulfillOrderStatus element : FulfillOrderStatus.values()) {
            map.put(element.getCode(), element.getMsg());
        }
        return map;
    }

    public static FulfillOrderStatus getByCode(Integer code) {
        for (FulfillOrderStatus element : FulfillOrderStatus.values()) {
            if (code.equals(element.getCode())) {
                return element;
            }
        }
        return null;
    }

    public static Set<Integer> allowableValues() {
        Set<Integer> allowableValues = new HashSet<>(values().length);
        for (FulfillOrderStatus orderStatusEnum : values()) {
            allowableValues.add(orderStatusEnum.getCode());
        }
        return allowableValues;
    }
}