package com.edu.ulab.app.storage.entities.user;

import com.edu.ulab.app.storage.entities.StorageEntityData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class UserStorageEntityData implements StorageEntityData {
    Long id;
    String fullName;
    String title;
    int age;
}
