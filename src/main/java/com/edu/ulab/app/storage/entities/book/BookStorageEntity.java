package com.edu.ulab.app.storage.entities.book;


import com.edu.ulab.app.storage.entities.StorageEntity;
import com.edu.ulab.app.storage.entities.StorageEntityData;
import com.edu.ulab.app.storage.entities.user.UserStorageEntityData;
import com.edu.ulab.app.storage.exception.StorageEntityNotFoundException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BookStorageEntity implements StorageEntity {

    Map<Long, BookStorageEntityData> data = new ConcurrentHashMap<>();


    @Override
    public StorageEntityData create(@NonNull StorageEntityData entityData) throws StorageEntityNotFoundException {
        if (!(entityData instanceof BookStorageEntityData bookData)) {
            throw new StorageEntityNotFoundException("");
        }
        return data.put(bookData.getId(), bookData);
    }

    @Override
    public StorageEntityData update(@NonNull StorageEntityData entityData) {
        return create(entityData);
    }

    @Override
    public StorageEntityData getByKey(@NonNull Object keyValue) {
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
