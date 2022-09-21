package com.edu.ulab.app.storage.tables;

import com.edu.ulab.app.storage.StorageEntityData;
import com.edu.ulab.app.storage.exceptions.StorageEntityNotFoundException;


public interface StorageTable<T extends StorageEntityData> {

    T create(T entityData) throws StorageEntityNotFoundException;

    T update(T entityData);

}
