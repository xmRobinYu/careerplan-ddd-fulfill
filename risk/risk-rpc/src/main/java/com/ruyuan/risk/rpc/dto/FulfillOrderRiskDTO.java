package com.ruyuan.risk.rpc.dto;

import java.io.Serializable;

/**
 * 履约单风控拦截响应对象
 * @author zhonghuashishan
 * @version 1.0
 */
public class FulfillOrderRiskDTO implements Serializable {

    private static final long serialVersionUID = 8522180606790549375L;
    /**
     * 风控检查结果
     */
    private Boolean riskResult;

    /**
     * 风控检查说明
     */
    private String riskComment;

    public Boolean getRiskResult() {
        return riskResult;
    }

    public void setRiskResult(Boolean riskResult) {
        this.riskResult = riskResult;
    }

    public String getRiskComment() {
        return riskComment;
    }

    public void setRiskComment(String riskComment) {
        this.riskComment = riskComment;
    }
}