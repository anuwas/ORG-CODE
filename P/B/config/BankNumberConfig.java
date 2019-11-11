package com.mes.ps.billing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration class for bank number configuration
 */
@Configuration
@ConfigurationProperties(prefix = "mes.bank")
public class BankNumberConfig {
 
    private List<Integer> numbers;
 
    BankNumberConfig() {
        this.numbers = new ArrayList<>();
    }
 
    public List<Integer> getNumbers() {
        return this.numbers;
    }
 
}