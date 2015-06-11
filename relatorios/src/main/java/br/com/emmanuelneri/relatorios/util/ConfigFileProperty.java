package br.com.emmanuelneri.relatorios.util;

import org.apache.deltaspike.core.api.config.PropertyFileConfig;

public class ConfigFileProperty implements PropertyFileConfig {

    @Override
    public String getPropertyFileName() {
        return "/config/application.properties";
    }

    @Override
    public boolean isOptional() {
        return false;
    }
}