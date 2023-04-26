package com.ruyuan.fulfill.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFulfillOrderCommand {
    private String orderId;
}
