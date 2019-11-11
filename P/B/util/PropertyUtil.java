package com.mes.ps.billing.util;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;


/**
 * Utility class for loading configuration property
 */
public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    /**
     * Generate config object from configuration files
     * @param filePath
     * @return
     */
    public static Configuration loadProperties(String filePath) {
        Configuration config = null;

        try {
            URL url = PropertyUtil.class.getResource(filePath);
            config = new Configurations().properties(url);
        } catch (Exception e) {
            logger.error("", e);
        }

        return config;
    }
}
