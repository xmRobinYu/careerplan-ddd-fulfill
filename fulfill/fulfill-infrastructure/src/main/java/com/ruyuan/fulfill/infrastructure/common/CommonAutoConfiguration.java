package com.ruyuan.fulfill.infrastructure.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
@Configuration
@Import(value = {MybatisPlusConfig.class})
public class CommonAutoConfiguration {

}