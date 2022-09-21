package com.edu.ulab.app.storage;

public interface Storage {

    StorageEntityData create(String entityTitle, StorageEntityData storageEntityData);

    StorageEntityData update(String entityTitle, StorageEntityData storageEntityData);

    StorageEntityData getEntityByKey(String entityTitle, Object id);

    void deleteEntityByKey(String entityTitle, Object id);
}
