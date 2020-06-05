package com.morefans.common.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.morefans.common.mybatis.properties.MybatisProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Created by tanxw on 2019/2/19.
 */
@EnableConfigurationProperties(MybatisProperties.class)
@Configuration
public class MybatisConfig implements TransactionManagementConfigurer {

    @Autowired
    private MybatisProperties properties;

    @Autowired(required = false)
    private Interceptor[] interceptors;

    @Autowired(required = false)
    private DatabaseIdProvider databaseIdProvider;

    public MybatisConfig() {
    }

    @PostConstruct
    public void checkConfigFileExists() {
        if(properties.isCheckConfigLocation() && StringUtils.hasText(properties.getConfigLocation())) {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(properties.getConfigLocation());
            Assert.state(resource.exists(), "Cannot find config location: " + resource + " (please add config file or check your Mybatis " + "configuration)");
        }

    }

    /**
     * 配置druid 数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setVfs(SpringBootVFS.class);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        if(StringUtils.hasText(properties.getConfigLocation())) {
            factory.setConfigLocation(resolver.getResource(properties.getConfigLocation()));
        }
        factory.setConfiguration(properties.getConfiguration());
        if(!ObjectUtils.isEmpty(interceptors)) {
            factory.setPlugins(interceptors);
        }else {
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);
            factory.setPlugins(new Interceptor[]{pageHelper});
        }

        if(databaseIdProvider != null) {
            factory.setDatabaseIdProvider(databaseIdProvider);
        }

        if(StringUtils.hasLength(properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(properties.getTypeAliasesPackage());
        }

        if(StringUtils.hasLength(properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(properties.getTypeHandlersPackage());
        }

        if(!ObjectUtils.isEmpty(properties.getMapperLocation())) {
            factory.setMapperLocations(resolver.getResources(properties.getMapperLocation()));
        }
        return factory.getObject();
    }

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception{
        ExecutorType executorType = properties.getExecutorType();
        return executorType != null?new SqlSessionTemplate(sqlSessionFactory(), executorType):new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
