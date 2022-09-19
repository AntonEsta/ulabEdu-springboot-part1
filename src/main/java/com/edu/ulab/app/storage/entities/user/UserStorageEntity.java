package com.edu.ulab.app.storage.entities.user;


import com.edu.ulab.app.storage.entities.StorageEntity;
import com.edu.ulab.app.storage.entities.StorageEntityData;
import com.edu.ulab.app.storage.exception.StorageEntityNotFoundException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserStorageEntity implements StorageEntity {

    Map<Long, UserStorageEntityData> data = new ConcurrentHashMap<>();

    public UserStorageEntity(){};

    @Override
    public StorageEntityData create(@NonNull StorageEntityData entityData) throws StorageEntityNotFoundException {
        if (!(entityData instanceof UserStorageEntityData userData)) {
            throw new StorageEntityNotFoundException("");
        }
        return data.put(userData.getId(), userData);
    }

    @Override
    public StorageEntityData update(@NonNull StorageEntityData entityData) {
        return create(entityData);
    }

    @Override
    public StorageEntityData getByKey(Object keyValue) {
        if (keyValue instanceof Long) {
            return data.get(keyValue);
        }
        return null;
    }

    @Override
    public void deleteByKey(Object keyValue) {
        if (keyValue instanceof Long) {
            data.remove(keyValue);
        }
    }

}
