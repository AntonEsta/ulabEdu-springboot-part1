package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.entities.book.BookStorageEntity;
import com.edu.ulab.app.storage.entities.user.UserStorageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public final class StorageFactory {

    @Autowired
    public static Storage appInnerStorage(UserStorageEntity userStorageEntity, BookStorageEntity bookStorageEntity) {

        if (Objects.isNull(userStorageEntity) || Objects.isNull(bookStorageEntity)) {
            return null;
        }

        Collection<StorageEntitySetter> entitySetters = new ArrayList<>();

        StorageEntitySetter userEntitySetter = StorageEntitySetter.builder()
                .title("User")
                .storageEntity(userStorageEntity)
                .build();

        entitySetters.add(userEntitySetter);

        StorageEntitySetter bookEntitySetter = StorageEntitySetter.builder()
                .title("Book")
                .storageEntity(userStorageEntity)
                .build();

        entitySetters.add(bookEntitySetter);

        return new InnerStorage((StorageEntitySetter[]) entitySetters.toArray());
    }

}
