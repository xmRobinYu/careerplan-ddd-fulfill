package com.ruyuan.fulfill.application.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterceptedFulfillOrderAuditResultDTO {

    private String fulfillId;
    private Boolean auditResult;
}
