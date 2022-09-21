package com.edu.ulab.app.storage.entities;

import com.edu.ulab.app.storage.StorageEntityData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class BookStorageEntityData implements StorageEntityData {
    Long id;
    Long userId;
    String title;
    String author;
    int pageCount;
}
