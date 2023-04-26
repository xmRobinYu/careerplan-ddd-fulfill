package com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 履约状态记录数据层对象
 *
 * @author zhonghuashishan
 */
@Data
@TableName("fulfill_log")
public class FulfillLogDO implements Serializable {

    private static final long serialVersionUID = -6686114207740714650L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 履约单号
     */
    private String fulfillId;

    /**
     * 履约单前置状态 10 已创建 20 已出库 30 已配送
     */
    private Integer beforeStatus;

    /**
     * 履约单当前状态 10 已创建 20 已出库 30 已配送
     */
    private Integer currentStatus;

}