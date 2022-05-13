package com.college.attendance.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


@Configuration("appConfig")
public class AppConfig {

    @Value(value = "${spring.eDatasource.primary.url}")
    private String dBUrl;

    @Value(value = "${spring.eDatasource.primary.username}")
    private String userName;

    @Value(value = "${spring.eDatasource.primary.password}")
    private String password;

    @Value(value = "${spring.eDatasource.primary.driverClassName}")
    private String driverName;

    @Value(value = "${spring.eDatasource.primary.max.connectionpool}")
    private Integer maxConnectionPoolSize;

    @Value(value = "${spring.eDatasource.primary.initialPool}")
    private Integer initialPoolSize;

    @Value(value = "${spring.eDatasource.primary.connection.minIdle}")
    private Integer connectionMinIdle;

    @Value(value = "${spring.eDatasource.primary.connection.validation.interval}")
    private Integer validationInterval;


    @Primary
    @Bean("dataSource")
    public DataSource defaultDataSource() {

        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(getProperty(dBUrl, driverName, userName, password, validationInterval,
                maxConnectionPoolSize, initialPoolSize, connectionMinIdle));

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource defaultDs) {
        return new JdbcTemplate(defaultDs);
    }

    @Bean(name = "postpaidNamedJdbcTemplate")
    public NamedParameterJdbcTemplate postpaidNamedJdbcTemplate(@Qualifier("dataSource") DataSource dsBtfly) {
        return new NamedParameterJdbcTemplate(dsBtfly);
    }


    private PoolProperties getProperty(String url, String driverName, String userName, String password, Integer validationInterval,
                                       Integer maxConnectionPoolSize, Integer initialPoolSize, Integer connectionMinIdle) {
        PoolProperties p = new PoolProperties();
        p.setUrl(url);
        p.setDriverClassName(driverName);
        p.setUsername(userName);
        p.setPassword(password);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1 FROM DUAL");
        p.setTestOnReturn(false);
        p.setValidationInterval(validationInterval);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(maxConnectionPoolSize);
        p.setInitialSize(initialPoolSize);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(connectionMinIdle);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
        return p;
    }
}
