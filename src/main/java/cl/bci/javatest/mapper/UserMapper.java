package cl.bci.javatest.mapper;

import cl.bci.javatest.dto.request.CreateUserRequestDTO;
import cl.bci.javatest.dto.response.CreateUserResponseDTO;
import cl.bci.javatest.dto.response.ListUsersResponseDTO;
import cl.bci.javatest.jpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phone", source = "phones")
    User toEntity(CreateUserRequestDTO createUserRequestDTO);

    @Mapping(target = "email", source = "createUserRequestDTO.email")
    @Mapping(target = "name", source = "createUserRequestDTO.name")
    @Mapping(target = "password", source = "createUserRequestDTO.password")
    @Mapping(target = "phone", source = "createUserRequestDTO.phones")
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    User toEntity(CreateUserRequestDTO createUserRequestDTO, String token);

    User toEntity(CreateUserResponseDTO createUserResponseDTO);

    CreateUserRequestDTO toUserRequest(User user);

    @Mapping(target = "created_at", source = "user.created")
    @Mapping(target = "last_modified_at", source = "user.modified")
    @Mapping(target = "last_login_at", source = "user.lastLogin")
    @Mapping(target = "token", source = "user.token")
    CreateUserResponseDTO toUserResponse(User user);

    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "phones", source = "user.phone")
    @Mapping(target = "created_at", source = "user.created")
    @Mapping(target = "last_modified_at", source = "user.modified")
    @Mapping(target = "last_login_at", source = "user.lastLogin")
    ListUsersResponseDTO toListUsersResponse(User user);

}
