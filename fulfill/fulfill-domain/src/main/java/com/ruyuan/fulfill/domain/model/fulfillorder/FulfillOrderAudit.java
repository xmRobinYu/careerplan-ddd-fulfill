package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 履约单审核
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FulfillOrderAudit implements Serializable {

    /**
     * 风控状态 10 未通过 20 已通过
     */
    private Integer riskStatus;

    /**
     * 人工审核状态 10 未通过 20 已通过
     */
    private Integer manualReviewStatus;
}