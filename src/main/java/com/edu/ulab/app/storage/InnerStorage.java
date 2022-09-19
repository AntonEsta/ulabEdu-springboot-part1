package com.edu.ulab.app.storage;

import com.edu.ulab.app.storage.entities.StorageEntity;
import com.edu.ulab.app.storage.entities.StorageEntityData;
import com.edu.ulab.app.storage.exception.StorageEntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Component
public class InnerStorage implements Storage {

    private final ConcurrentMap<String, StorageEntity> storageEntities = new ConcurrentHashMap<>();

    private void postUpdate(StorageEntityData entityData) {

    }

    private StorageEntity getEntityByTitle(String title) {
        log.info("Founding storage entity by name \"" + title + "\"");
        StorageEntity entity = storageEntities.get(title.toLowerCase());
        if (Objects.isNull(entity)) {
            log.warn("Storage entity by name \"" + title + "\" not found.");
            throw new StorageEntityNotFoundException("Storage Entity by title \"" + title + "\" not found.");
        }
        return entity;
    }

    public InnerStorage(StorageEntitySetter ... entitySetters) {
        Arrays.stream(entitySetters)
                .forEach(s -> Objects.requireNonNull(storageEntities.put(s.getTitle().toLowerCase(), s.getStorageEntity())));
    }

    public StorageEntityData create(String entityTitle, StorageEntityData data) {

        StorageEntity storageEntity = getEntityByTitle(entityTitle);

        try {
            storageEntity.create(data);
        } catch (StorageEntityNotFoundException e) {
            log.warn("Creating new data end with error.");
            return null;
        }

        return null;
    }

    @Override
    public StorageEntityData update(String entityTitle, StorageEntityData data) {

        StorageEntity storageEntity = getEntityByTitle(entityTitle);

        try {
            StorageEntityData returnEntityData = storageEntity.update(data);
            if (returnEntityData != null) {
                postUpdate(returnEntityData);
            }
            return returnEntityData;

        } catch (StorageEntityNotFoundException e) {
            log.warn("Creating new data end with error.");
            return null;
        }

    }

    @Override
    public StorageEntityData getEntityByKey(String entityTitle, Object id) {
        StorageEntity storageEntity = getEntityByTitle(entityTitle);
        try {
            storageEntity.getByKey(id);
        } catch (NoSuchMethodError e) {
            return null;
        }

        return null;
    }

    @Override
    public void deleteEntityByKey(String entityTitle, Object id) {
        StorageEntity storageEntity = getEntityByTitle(entityTitle);
        try {
            storageEntity.deleteByKey(id);
        } catch (NoSuchMethodError ignored) {
        }
    }


    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции



}
