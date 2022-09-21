package com.edu.ulab.app.storage.tables;


import com.edu.ulab.app.storage.keys.unique.LongStorageTableUniqueKey;
import com.edu.ulab.app.storage.StorageEntityData;
import com.edu.ulab.app.storage.exceptions.StorageEntityNotFoundException;
import com.edu.ulab.app.storage.entities.BookStorageEntityData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class BookStorageTable extends StorageTableWithUniqueKey implements StorageTable {

    private final LongStorageTableUniqueKey id;
    private final Map<Long, BookStorageEntityData> data = new ConcurrentHashMap<>();

//    private Long getUID() {
//        return this.UID++;
//    }

    @Override
    public StorageEntityData create(@NonNull StorageEntityData entityData) throws StorageEntityNotFoundException {

        if (entityData instanceof BookStorageEntityData bookData) {
            bookData.setId(this.id.getNextValue());
            this.data.put(bookData.getId(), bookData);
            if (this.data.containsKey(bookData.getId())) {
                return bookData;
            }
        }

        throw new StorageEntityNotFoundException("Can't create new book record.");
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
