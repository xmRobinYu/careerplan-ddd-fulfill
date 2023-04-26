package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.Getter;

/**
 * 履约单id
 * @author zhonghuashishan
 * @version 1.0
 */
@Getter
public class FulfillId {
    private Long id;
    private String fulfillId;

    private FulfillId() {}

    public static FulfillId of(String fulfillId) {
        FulfillId id = new FulfillId();
        id.fulfillId = fulfillId;
        return id;
    }


    public static FulfillId of(String fulfillId, Long id) {
        FulfillId oid = new FulfillId();
        oid.fulfillId = fulfillId;
        oid.id = id;
        return oid;
    }
}
