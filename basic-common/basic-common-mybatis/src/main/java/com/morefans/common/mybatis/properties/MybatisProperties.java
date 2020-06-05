package com.morefans.common.mybatis.properties;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by tanxw on 2019/2/19.
 */
@ConfigurationProperties(
        prefix = "morefans.mybatis"
)
public class MybatisProperties {
    public static final String MYBATIS_PREFIX = "morefans.mybatis";
    /***mybatis 配置文件：classpath:mybatis-config.xml*/
    private String configLocation;
    /**映射配置文件：classpath:/mybatis/*.xml*/
    private String mapperLocation;
    /**model扫描文件路径*/
    private String typeAliasesPackage;
    /**mapper类扫描路径*/
    private String mapperPackage;
    /**handler类扫描路径*/
    private String typeHandlersPackage;
    /**检查mybatis配置文件*/
    private boolean checkConfigLocation = false;
    /**执行器类型：SIMPLE、REUSE、BATCH*/
    private ExecutorType executorType;

    /**配置信息,如mybatis-config.xml中configuration元素对象*/
    private Configuration configuration;

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String getMapperLocation() {
        return mapperLocation;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getTypeHandlersPackage() {
        return typeHandlersPackage;
    }

    public void setTypeHandlersPackage(String typeHandlersPackage) {
        this.typeHandlersPackage = typeHandlersPackage;
    }

    public boolean isCheckConfigLocation() {
        return checkConfigLocation;
    }

    public void setCheckConfigLocation(boolean checkConfigLocation) {
        this.checkConfigLocation = checkConfigLocation;
    }

    public ExecutorType getExecutorType() {
        return executorType;
    }

    public void setExecutorType(ExecutorType executorType) {
        this.executorType = executorType;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
