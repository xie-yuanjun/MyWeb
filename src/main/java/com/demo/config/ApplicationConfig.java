package com.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import java.beans.PropertyVetoException;

/**
 * @author admin
 * @Title: ApplicationConfig
 * @ProjectName word
 * @Description: TODO
 * @date 2021/6/30:11
 */
@Configuration
public class ApplicationConfig {
//    @NacosInjected
//    private NamingService namingService;
//
//    @PostConstruct
//    public void registerService() throws NacosException {
//        //注册服务 服务名：word , IP：172.0.0.1 , 端口：8080
//        namingService.registerInstance("word", "172.0.0.1", 8080);
//    }

    @Bean
    @Nonnull
    ComboPooledDataSource dataSources() throws PropertyVetoException {
        ComboPooledDataSource dataSources = new ComboPooledDataSource();
        dataSources.setJdbcUrl("jdbc:mysql://linux:3306/test?useSSL=true&useUnicode=true&characterEncoding=utf-8");
        dataSources.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSources.setUser("root");
        dataSources.setPassword("123456");
        return dataSources;
    }

}
