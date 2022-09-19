package com.edu.ulab.app.mapper;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.storage.entities.book.BookStorageEntityData;
import com.edu.ulab.app.storage.entities.user.UserStorageEntityData;
import com.edu.ulab.app.web.request.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto bookRequestToBookDto(BookRequest bookRequest);

    BookRequest bookDtoToBookRequest(BookDto bookDto);

    BookStorageEntityData bookDtoToBookStorageEntityData(BookDto bookDto);

    BookDto bookStorageEntityDataToBookDto(BookStorageEntityData bookStorageEntityData);

}
