package com.twoguysandadream.fantasy.auction.dal.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

public interface JpaConfiguration {

    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean();

}