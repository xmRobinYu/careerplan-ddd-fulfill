package com.ruyuan.fulfill.domain.model.fulfillorder;

import com.ruyuan.fulfill.domain.gateway.FulfillOrderGateway;
import com.ruyuan.fulfill.domain.model.warehouse.Warehouse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 核心的领域模型：履约订单
 */
@Data
public class FulfillOrder {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 履约单ID
     */
    private FulfillId fulfillId;

    /**
     * 履约单条目
     */
    private List<FulfillOrderItem> fulfillOrderItems;

    /**
     * 配送地址信息
     */
    private DeliveryAddress deliveryAddress;

    /**
     * 支付类型
     */
    private PayType payType;

    /**
     * 支付信息
     */
    private PaymentDetail paymentDetail;

    /**
     * 履约单状态
     */
    private FulfillOrderStatus fulfillOrderStatus;

    /**
     * 物流单
     */
    private LogisticsOrder logisticsOrder;

    /**
     * 履约单下发仓库信息
     */
    private FulfillOrderWarehouse fulfillOrderWarehouse;

    /**
     * 履约单风控信息
     */
    private FulfillOrderAudit fulfillOrderAudit;


    /**
     *
     */
    private FulfillOrderGateway fulfillOrderGateway;

    public List<String> getSkuCodes() {
        return fulfillOrderItems.stream().map(FulfillOrderItem::getSkuCode).collect(Collectors.toList());
    }

    public List<Integer> getPurchaseCounts() {
        return fulfillOrderItems.stream().map(FulfillOrderItem::getSaleQuantity).collect(Collectors.toList());
    }

    public void allocateToWarehouse(Warehouse warehouse) {
        fulfillOrderGateway.saveAllocatedWarehouse(this, warehouse);
    }

    public void allocatedLogisticsOrder(LogisticsOrder logisticsOrder) {
        fulfillOrderGateway.saveAllocatedLogisticsOrder(this, logisticsOrder);
    }

    public void riskPass() {
        fulfillOrderGateway.updateRiskStatus(fulfillId,RiskStatus.PASSED.getCode());
        getFulfillOrderAudit_().setRiskStatus(RiskStatus.PASSED.getCode());
    }

    public void riskReject() {
        fulfillOrderGateway.updateRiskStatus(fulfillId,RiskStatus.UN_PASS.getCode());
        getFulfillOrderAudit_().setRiskStatus(RiskStatus.UN_PASS.getCode());
    }

    public void manualReviewPass() {
        fulfillOrderGateway.updateManualReviewStatus(fulfillId,ManualReviewStatus.PASSED.getCode());
        getFulfillOrderAudit_().setManualReviewStatus(RiskStatus.PASSED.getCode());
    }

    public void manualReviewReject() {
        fulfillOrderGateway.updateManualReviewStatus(fulfillId,ManualReviewStatus.UN_PASS.getCode());
        getFulfillOrderAudit_().setManualReviewStatus(RiskStatus.UN_PASS.getCode());
    }

    private FulfillOrderAudit getFulfillOrderAudit_() {
        if (null == fulfillOrderAudit) {
            fulfillOrderAudit = new FulfillOrderAudit();
        }
        return fulfillOrderAudit;
    }
}
