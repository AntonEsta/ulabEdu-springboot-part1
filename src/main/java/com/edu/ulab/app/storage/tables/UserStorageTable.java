package com.edu.ulab.app.storage.tables;


import com.edu.ulab.app.storage.keys.unique.LongStorageTableUniqueKey;
import com.edu.ulab.app.storage.StorageEntityData;
import com.edu.ulab.app.storage.exceptions.StorageEntityNotFoundException;
import com.edu.ulab.app.storage.entities.UserStorageEntityData;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserStorageTable implements StorageTable {

    private LongStorageTableUniqueKey id;
    private Map<Long, UserStorageEntityData> data = new ConcurrentHashMap<>();

    public UserStorageTable(){};

    private Long getUID() {
        return this.id.getNextValue();
    }

    @Override
    public StorageEntityData create(@NonNull StorageEntityData entityData) throws StorageEntityNotFoundException {

        if (entityData instanceof UserStorageEntityData userData) {
            userData.setId(getUID());
            this.data.put(userData.getId(), userData);
            if (this.data.containsKey(userData.getId())) {
                return userData;
            }
        }

        throw new StorageEntityNotFoundException("Can't create new user record.");
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
