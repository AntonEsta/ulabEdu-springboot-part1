package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.entities.StorageEntityData;

public interface Storage {

    StorageEntityData create(String entityTitle, StorageEntityData storageEntityData);

    StorageEntityData update(String entityTitle, StorageEntityData storageEntityData);

    StorageEntityData getEntityByKey(String entityTitle, Object id);

    void deleteEntityByKey(String entityTitle, Object id);
}
