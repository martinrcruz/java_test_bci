package cl.bci.javatest.service;

import cl.bci.javatest.dto.request.CreateUserRequestDTO;
import cl.bci.javatest.util.BciResponse;

public interface IUserService {
    public BciResponse createUser(CreateUserRequestDTO createUserRequestDTO) throws Exception;
    public BciResponse listUsers() throws Exception;
}
