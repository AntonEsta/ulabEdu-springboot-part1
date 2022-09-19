package com.edu.ulab.app.storage.entities;

import com.edu.ulab.app.storage.exception.StorageEntityNotFoundException;


public interface StorageEntity {

    StorageEntityData create(StorageEntityData entityData) throws StorageEntityNotFoundException;

    StorageEntityData update(StorageEntityData entityData);

    StorageEntityData getByKey(Object keyValue);

    void deleteByKey(Object keyValue);
}
