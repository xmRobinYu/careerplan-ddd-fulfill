package com.ruyuan.fulfill.api.web.request;

import lombok.Data;

/**
 * 审核被风控拦截的履约单
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
public class AuditInterceptedFulfillOrderRequest {

    /**
     * 履约单ID
     */
    private String fulfillId;

    /**
     * 审核结果
     */
    private Boolean auditResult;
}
