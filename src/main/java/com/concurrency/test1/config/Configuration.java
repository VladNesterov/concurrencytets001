package com.concurrency.test1.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.constructs.blocking.BlockingCache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.management.NotCompliantMBeanException;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class Configuration {

    @Bean
    public Ehcache getEhCache() throws NotCompliantMBeanException {
        CacheManager cacheManager = CacheManager.create();
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("Balance");
        cacheConfiguration.setLogging(true);
        Ehcache ehcache = new BlockingCache(new Cache(cacheConfiguration));
        return ehcache;
    }


//    @Bean(name = "cacheManager")
//    @Scope("prototype")
//    public CacheManager getCacheManager() {
//        return new EhCacheCacheManager(getEhCacheFactory().getObject());
//    }
//
//    @Bean
//    @Scope("prototype")
//    public EhCacheManagerFactoryBean getEhCacheFactory() {
//        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        factoryBean.setShared(true);
//        return factoryBean;
//    }
}
