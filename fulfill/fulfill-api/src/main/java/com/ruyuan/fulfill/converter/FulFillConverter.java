package com.ruyuan.fulfill.converter;

import com.ruyuan.fulfill.application.command.dto.FulfillOrderCommandDTO;
import com.ruyuan.fulfill.application.command.dto.FulfillOrderDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Mapper(componentModel = "spring")
@Component
public interface FulFillConverter {
    /**
     * 转换对象
     *
     * @param fulfillOrderCommandDTO 对象
     * @return 对象
     */
    FulfillOrderDTO convertFulfillOrderCommandDTO(FulfillOrderCommandDTO fulfillOrderCommandDTO);

}
