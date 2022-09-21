package com.edu.ulab.app.mapper;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.storage.entities.UserStorageEntityData;
import com.edu.ulab.app.web.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userRequestToUserDto(UserRequest userRequest);

    UserRequest userDtoToUserRequest(UserDto userDto);

    UserStorageEntityData userDtoToUserStorageEntityData(UserDto userDto);

    UserDto userStorageEntityDataToUserDto(UserStorageEntityData userStorageEntityData);
}
