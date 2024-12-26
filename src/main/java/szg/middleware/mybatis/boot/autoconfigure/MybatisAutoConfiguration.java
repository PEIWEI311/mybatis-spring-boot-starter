package szg.middleware.mybatis.boot.autoconfigure;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * MyBatis 自动配置类
 */
@Configuration
@ConditionalOnClass(SqlSessionFactory.class) // 检查 SqlSessionFactory 类是否存在
@EnableConfigurationProperties(MybatisProperties.class) // 启用自定义配置类
public class MybatisAutoConfiguration {

    private final MybatisProperties properties;

    public MybatisAutoConfiguration(MybatisProperties properties) {
        this.properties = properties;
        System.out.println("MybatisAutoConfiguration loaded with properties: " + properties);
    }

    /**
     * 配置数据源
     */
    @Bean
    @ConditionalOnMissingBean(DataSource.class) // 如果没有用户自定义的数据源，则加载此默认数据源
    public DataSource dataSource() {
        System.out.println("Configuring DataSource...");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriver());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        System.out.println("DataSource configured: " + dataSource.getJdbcUrl());
        return dataSource;
    }

    /**
     * 配置 SqlSessionFactory
     */
    @Bean
    @ConditionalOnMissingBean(SqlSessionFactory.class) // 如果没有用户自定义的 SqlSessionFactory，则加载此默认配置
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        System.out.println("Configuring SqlSessionFactory...");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        System.out.println("SqlSessionFactory configured successfully.");
        return sqlSessionFactory;
    }

    /**
     * 配置 MapperScannerConfigurer，用于扫描 Mapper 接口
     */
    @Bean
    @ConditionalOnMissingBean // 如果没有用户自定义的 MapperScannerConfigurer，则加载此默认配置
    public MapperScannerConfigurer mapperScannerConfigurer() {
        System.out.println("Configuring MapperScannerConfigurer...");
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(properties.getBasePackage());
        System.out.println("MapperScannerConfigurer configured for base package: " + properties.getBasePackage());
        return configurer;
    }

    /**
     * 配置事务管理器
     */
    @Bean
    @ConditionalOnMissingBean(DataSourceTransactionManager.class) // 如果没有用户自定义的事务管理器，则加载此默认配置
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        System.out.println("Configuring TransactionManager...");
        return new DataSourceTransactionManager(dataSource);
    }
}
