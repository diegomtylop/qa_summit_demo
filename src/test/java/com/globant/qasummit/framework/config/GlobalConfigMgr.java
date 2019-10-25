package com.globant.qasummit.framework.config;

import java.util.Properties;

/**
 * Implements the singleton pattern
 */
public class GlobalConfigMgr {

    private static final String PROP_FILE = "/config.properties";

    private static GlobalConfigMgr singleton;
    Properties props;


    public static GlobalConfigMgr getInstance(){
        if( singleton == null ){
            singleton = new GlobalConfigMgr();
        }
        return singleton;
    }

    private GlobalConfigMgr(){
        this.props = new Properties();
        try {
            props.load(GlobalConfigMgr.class.getResourceAsStream(PROP_FILE));
        } catch (Exception e) {
            System.err.println("Error reading property");

        }
    }

    public String getProperty(String key ){
        String value = props.getProperty( key );
        if( value == null ){
            throw  new RuntimeException("Property not found: "+key);
        }
        return value;
    }

}
