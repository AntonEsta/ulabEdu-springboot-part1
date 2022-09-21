package com.edu.ulab.app.config;

import com.edu.ulab.app.storage.Storage;
import com.edu.ulab.app.storage.StorageTablesSetter;
import com.edu.ulab.app.storage.StorageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    public Storage appInnerStorageConfig() {
        return StorageFactory.getAppInnerStorage();
    }

    @Bean
    public StorageTablesSetter[] StorageConfigEntitySetters() {
        return new StorageTablesSetter[]{};
    }

}
