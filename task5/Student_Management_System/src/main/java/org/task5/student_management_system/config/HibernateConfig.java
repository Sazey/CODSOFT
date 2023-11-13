//package org.task5.student_management_system.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//@Configuration
//public class HibernateConfig {
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setPackagesToScan("org.task5.student_management_system.model");
//        sessionFactory.setDataSource(dataSource());
//        // Add other Hibernate properties as needed
//        return sessionFactory;
//    }
//
//    // Add a DataSource bean if not provided by Spring Boot auto-configuration
//    // ...
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder.create().;
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.sqlite.JDBC");
//        dataSource.setUrl("jdbc:sqlite:/path/to/your/database.db");
//        return dataSource;
//    }
//
//    // Add other beans as needed
//}
