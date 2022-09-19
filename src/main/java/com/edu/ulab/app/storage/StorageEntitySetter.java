package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.entities.StorageEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Component
public class StorageEntitySetter {
    String title;
    StorageEntity storageEntity;
}
