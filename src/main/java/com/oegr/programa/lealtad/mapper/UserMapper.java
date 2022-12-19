package com.oegr.programa.lealtad.mapper;

import com.oegr.programa.lealtad.dto.UserDTO;
import com.oegr.programa.lealtad.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDTO toDTO(User data);
    User toEntity(UserDTO data);

}
