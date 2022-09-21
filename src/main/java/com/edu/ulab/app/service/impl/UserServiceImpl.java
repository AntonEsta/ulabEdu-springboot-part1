package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.mapper.UserMapper;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import com.edu.ulab.app.storage.StorageEntityData;
import com.edu.ulab.app.storage.entities.UserStorageEntityData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    @Qualifier("InnerStorage")
    private final Storage storage;

    private final UserMapper userMapper;

    @Override
    public UserDto createUser(@NonNull UserDto userDto) {
        StorageEntityData createdUserDto = storage.create("Users", userMapper.userDtoToUserStorageEntityData(userDto));
        return userMapper.userStorageEntityDataToUserDto((UserStorageEntityData) createdUserDto);
        // сгенерировать идентификатор
        // создать пользователя
        // вернуть сохраненного пользователя со всеми необходимыми полями id
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
