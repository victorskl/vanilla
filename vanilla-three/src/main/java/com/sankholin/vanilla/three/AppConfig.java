package com.sankholin.vanilla.three;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.sankholin.vanilla.three.service",
        "com.sankholin.vanilla.three.dao"
})
public class AppConfig {
}