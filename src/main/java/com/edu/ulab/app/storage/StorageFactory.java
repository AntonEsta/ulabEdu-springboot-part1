package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.tables.BookStorageTable;
import com.edu.ulab.app.storage.tables.UserStorageTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


public final class StorageFactory {


//    public static Storage getAppInnerStorage(UserStorageEntity userStorageEntity, BookStorageEntity bookStorageEntity) {
    public static Storage getAppInnerStorage() {

//        if (Objects.isNull(userStorageEntity) || Objects.isNull(bookStorageEntity)) {
//            return new InnerStorage(null);
//        }

        Collection<StorageTablesSetter> entitySetters = new ArrayList<>();

        StorageTablesSetter userEntitySetter = StorageTablesSetter.builder()
                .title("User")
                .storageEntity(new UserStorageTable())
                .build();

        entitySetters.add(userEntitySetter);

        StorageTablesSetter bookEntitySetter = StorageTablesSetter.builder()
                .title("Book")
                .storageEntity(new BookStorageTable())
                .build();

        entitySetters.add(bookEntitySetter);

        return new InnerStorage(entitySetters.stream().filter(Objects::nonNull).toArray(StorageTablesSetter[]::new));
    }

}
