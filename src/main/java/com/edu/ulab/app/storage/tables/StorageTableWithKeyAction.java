package com.edu.ulab.app.storage.tables;

import com.edu.ulab.app.storage.keys.unique.StorageTableUniqueKey;

public interface StorageTableWithKeyAction {

    T getByKey(StorageTableUniqueKey<?> keyValue);

    void deleteByKey(StorageTableUniqueKey<?> keyValue);

}
