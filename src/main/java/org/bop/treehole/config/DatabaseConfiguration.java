package org.bop.treehole.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.bop.treehole.dao")
public class DatabaseConfiguration {
    // Empty block
}
