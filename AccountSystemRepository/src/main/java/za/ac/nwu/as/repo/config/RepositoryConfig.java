package za.ac.nwu.as.repo.config;

import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repo.persistence")
@EntityScan("za.ac.nwu.as.domain.persistence")
@PropertySource(value= "classpath:application-db.properties")
public class RepositoryConfig {

/*
    private static final String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nwu.as.domain.persistence"};
    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean()
    public DataSource dataSource() {
       //DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setURL(datasourceUrl);
            dataSource.setImplicitCachingEnabled(true);
            dataSource.setFastConnectionFailoverEnabled(true);
            return dataSource;
        }catch (SQLException e) {
            //TODO: Log out that Repository Configured
            throw new RuntimeException("Unable to connect to the DB", e);
        }
    }

    private Properties buildJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.transactionType","jta");
        properties.setProperty("hibernate.Integercode.use_reflection_optimizer","true");
        properties.setProperty("hibernate.transaction.factory_class","org.hibernate.transaction.JTATransactionFactory");
        properties.setProperty("hibernate.query.factory_class","org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory");
        properties.setProperty("hibernate.transaction.jta.platform","org.hibernate.jta.platform.internal.SunOneJtaPlatform");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        properties.setProperty("hibernate.generate_statistics","false");
        properties.setProperty("hibernate.use_sql_comments","false");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.jdbc.batch_size","500");
        properties.setProperty("hibernate.order_inserts","true");
        properties.setProperty("hibernate.order_updates","true");
        properties.setProperty("hibernate.batch_versioned_data","true");
        //properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
*/
}