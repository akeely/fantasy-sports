/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cache.HashtableCacheProvider;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.MySQLInnoDBDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * @author akeely
 *
 */
@Configuration
//@Profile("prod")
public class MySqlJpaConfiguration implements JpaConfiguration {

    private Map<String, Object> jpaProperties() {

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", MySQLInnoDBDialect.class.getName());
        props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
        return props;
    }
	
    private JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {

        return new JpaTransactionManager(localContainerEntityManagerFactoryBean().getObject());
    }

    /**
     * @see JpaConfiguration#localContainerEntityManagerFactoryBean()
     */
    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {

        System.out.println("Loading class context.");
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(this.dataSource());
        lef.setJpaPropertyMap(this.jpaProperties());
        lef.setJpaVendorAdapter(this.jpaVendorAdapter());
        return lef;
    }

    private DataSource dataSource() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://qcultimate.com:3306/akeely_java_auction_generated");
        dataSource.setUsername("akeely_auction");
        dataSource.setPassword("****");
        
        return dataSource;
    }
}
