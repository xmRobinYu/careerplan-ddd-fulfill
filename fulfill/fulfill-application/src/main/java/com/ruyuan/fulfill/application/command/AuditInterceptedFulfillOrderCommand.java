package com.ruyuan.fulfill.application.command;

import com.ruyuan.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 人工审核命令
 * @author zhonghuashishan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditInterceptedFulfillOrderCommand implements Serializable {

    private InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO;

}
