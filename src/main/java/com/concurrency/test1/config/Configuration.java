package com.concurrency.test1.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class Configuration {

    @Bean("customCacheManager")
    @Order(0)
    public org.springframework.cache.CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("Balance");
    }


}
