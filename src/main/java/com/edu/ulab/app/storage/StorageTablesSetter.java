package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.tables.StorageTable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Component
public class StorageTablesSetter {
    String title;
    StorageTable<?> storageEntity;
}
