package cl.bci.javatest.service.impl;

import cl.bci.javatest.dto.request.CreateUserRequestDTO;
import cl.bci.javatest.dto.response.ListUsersResponseDTO;
import cl.bci.javatest.exception.UserException;
import cl.bci.javatest.jpa.entity.User;
import cl.bci.javatest.jpa.repository.UserRepository;
import cl.bci.javatest.mapper.UserMapper;
import cl.bci.javatest.service.IUserService;
import cl.bci.javatest.util.BciResponse;
import cl.bci.javatest.util.JwtUtil;
import cl.bci.javatest.util.RegExUtil;
import cl.bci.javatest.util.enums.ResponseCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public BciResponse createUser(CreateUserRequestDTO createUserRequestDTO) throws UserException {
        try {
            User user = this.userRepository.getUserByEmail(createUserRequestDTO.getEmail());

            if (user != null) {
                log.error(UserServiceImpl.class + " Error creating user: User email is already taken.");
                return new BciResponse(null, UserException.UserCode.USER_ALREADY_EXISTS.getUserCode(), "Error al crear usuario. El correo ya está registrado!");
            } else if(!RegExUtil.getInstance().isValidEmail(createUserRequestDTO.getEmail())){
                log.error(UserServiceImpl.class + " Error creating user: Email format is not valid or does not satisfy required condition.");
                return new BciResponse(null, UserException.UserCode.USER_BAD_EMAIL_FORMAT.getUserCode(), "Error al crear usuario. Formato de correo no cumple las condiciones!");
            } else if(!RegExUtil.getInstance().isValidPassword(createUserRequestDTO.getPassword())){
                log.error(UserServiceImpl.class + " Error creating user: Password format is not valid or does not satisfy required condition.");
                return new BciResponse(null, UserException.UserCode.USER_BAD_PASSWORD_FORMAT.getUserCode(), "Error al crear usuario. Formato de contraseña no cumple las condiciones!");
            }

            user = this.userRepository.save(UserMapper.getInstance().toEntity(createUserRequestDTO, JwtUtil.generateToken(createUserRequestDTO.getName())));
            log.info(UserServiceImpl.class + " [SUCCESS] -> User with UUID: " + user.getId() +" created succesfully.");

            return new BciResponse(UserMapper.getInstance().toUserResponse(user), ResponseCode.CREATED.getResCode(), ResponseCode.CREATED.getResDesc());
        } catch (Exception e) {
            log.error(UserServiceImpl.class + " [ERROR] -> " + e.getMessage());
            throw new UserException(UserException.UserCode.USER_GENERAL_ERROR, " Error creating a user");
        }
    }

    @Override
    public BciResponse listUsers() throws UserException {
        try {
            List<User> userList = this.userRepository.listActiveUsers();
            List<ListUsersResponseDTO> userListDTO = new ArrayList<>();

            if(userList.isEmpty()){
                log.error(UserServiceImpl.class + "Error listing active users: Not Data Found.");
                return new BciResponse(UserException.UserCode.USER_DATA_NOT_FOUND.getUserCode(), "Error al listar usuarios activos. No hay resultados!");
            }

            for(User auxUser: userList){
                userListDTO.add(UserMapper.getInstance().toListUsersResponse(auxUser));
            }

            return new BciResponse(userListDTO, ResponseCode.SUCCESSFUL.getResCode(), ResponseCode.SUCCESSFUL.getResDesc());
        } catch (Exception e) {
            log.error(UserServiceImpl.class + "General Error" + e.getMessage());
            throw new UserException(UserException.UserCode.USER_GENERAL_ERROR, "Error listing active users");
        }
    }
}
