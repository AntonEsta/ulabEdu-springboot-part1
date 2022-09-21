package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.service.InnerStorageService;
import com.edu.ulab.app.storage.Storage;
import com.edu.ulab.app.storage.StorageEntityData;
import com.edu.ulab.app.storage.entities.BookStorageEntityData;
import com.edu.ulab.app.storage.entities.UserStorageEntityData;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InnerStorageServiceImpl implements InnerStorageService {

    private final UserMapper userMapper;
    private final BookMapper bookMapper;

    private final Storage appInnerStorage;

    public InnerStorageServiceImpl(UserMapper userMapper,
                                   BookMapper bookMapper,
                                   @Qualifier("appInnerStorageConfig") Storage appInnerStorage) {
        this.userMapper = userMapper;
        this.bookMapper = bookMapper;
        this.appInnerStorage = appInnerStorage;
    }

    @Override
    public BookDto createBook(@NonNull BookDto bookDto) {
        StorageEntityData storageEntityData = appInnerStorage.create("Book", bookMapper.bookDtoToBookStorageEntityData(bookDto));
        return bookMapper.bookStorageEntityDataToBookDto((BookStorageEntityData) storageEntityData);
    }

    @Override
    public BookDto updateBook(@NonNull BookDto bookDto) {
        StorageEntityData storageEntityData = appInnerStorage.update("Book", bookMapper.bookDtoToBookStorageEntityData(bookDto));
        return bookMapper.bookStorageEntityDataToBookDto((BookStorageEntityData) storageEntityData);
    }

    @Override
    public BookDto getBookById(@NonNull Long id) {
        StorageEntityData storageEntityData = appInnerStorage.getEntityByKey("Book", id);
        if (Objects.isNull(storageEntityData)) {
            return null;
        }
        return bookMapper.bookStorageEntityDataToBookDto((BookStorageEntityData) storageEntityData);
    }

    @Override
    public void deleteBookById(@NonNull Long id) {
        appInnerStorage.deleteEntityByKey("Book", id);
    }

    @Override
    public UserDto createUser(@NonNull UserDto userDto) {
        StorageEntityData storageEntityData = appInnerStorage.create("User", userMapper.userDtoToUserStorageEntityData(userDto));
        return userMapper.userStorageEntityDataToUserDto((UserStorageEntityData) storageEntityData);
    }

    @Override
    public UserDto updateUser(@NonNull UserDto userDto) {
        StorageEntityData storageEntityData = appInnerStorage.update("User", userMapper.userDtoToUserStorageEntityData(userDto));
        return userMapper.userStorageEntityDataToUserDto((UserStorageEntityData) storageEntityData);
    }

    @Override
    public UserDto getUserById(@NonNull Long id) {
        StorageEntityData storageEntityData = appInnerStorage.getEntityByKey("User", id);
        if (Objects.isNull(storageEntityData)) {
            return null;
        }
        return userMapper.userStorageEntityDataToUserDto((UserStorageEntityData) storageEntityData);
    }

    @Override
    public void deleteUserById(@NonNull Long id) {
        appInnerStorage.deleteEntityByKey("User", id);
    }
}
