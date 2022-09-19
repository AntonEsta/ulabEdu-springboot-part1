package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.service.InnerStorageService;
import com.edu.ulab.app.storage.Storage;
import com.edu.ulab.app.storage.entities.StorageEntityData;
import com.edu.ulab.app.storage.entities.book.BookStorageEntityData;
import com.edu.ulab.app.storage.entities.user.UserStorageEntityData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InnerStorageServiceImpl implements InnerStorageService {

    private UserMapper userMapper;
    private BookMapper bookMapper;
    private final Storage appInnerStorage;

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
