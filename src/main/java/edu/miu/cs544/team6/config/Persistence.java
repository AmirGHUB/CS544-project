//package edu.miu.cs544.team6.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.*;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.Properties;
//
////import org.dozer.DozerBeanMapper;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("edu.miu.cs544.team6.repository")
//@EnableJpaRepositories("edu.miu.cs544.team6.repository")
//@PropertySource(value="classpath:application.yml")
//public class Persistence {
//    @Resource
//    public Environment environment;
//
//    @Bean(name = "dataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/team6?useSSL=false");
//        dataSource.setUsername("team6");
//        dataSource.setPassword("team6");
//        return dataSource;
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setPackagesToScan(new String[] { "edu.miu.cs544.team6.domain" });
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
//        factoryBean.setJpaVendorAdapter(vendorAdapter);
//        factoryBean.setJpaProperties(getJpaProperties());
//        return factoryBean;
//    }
//
//    private Properties getJpaProperties() {
//        return new Properties() {
//            {
//                setProperty("spring.jpa.hibernate.hbm2ddl.auto","create");
////                setProperty("hibernate.hbm2ddl.import_files", environment.getProperty("create.sql"));
////                setProperty("hibernate.hbm2ddl.import_files", environment.getProperty("import.sql"));
//                setProperty("hibernate.hbm2ddl.import_files", "classpath:populate.sql");
//                setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//                setProperty("spring.jpa.show-sql", "true");
//                setProperty("spring.jpa.format-sql", "false");
//           }
//        };
//    }
//
//
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//
//}