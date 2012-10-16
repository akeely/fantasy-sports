package com.twoguysandadream.fantasy.auction.dal.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cache.HashtableCacheProvider;
import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@Profile("dev")
public class EmbeddedDbJpaConfiguration implements JpaConfiguration {


    private Map<String, Object> jpaProperties() {

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", H2Dialect.class.getName());
        props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
        return props;
    }


    private JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
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
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(this.dataSource());
        lef.setJpaPropertyMap(this.jpaProperties());
        lef.setJpaVendorAdapter(this.jpaVendorAdapter());
        return lef;
    }

    private DataSource dataSource() {

        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}
