package cl.bci.javatest.controller;


import cl.bci.javatest.dto.request.CreateUserRequestDTO;
import cl.bci.javatest.exception.UserException;
import cl.bci.javatest.service.IUserService;
import cl.bci.javatest.util.BciResponse;
import cl.bci.javatest.util.enums.ResponseCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void test_createUser_OK() throws Exception {
        // Create a valid request DTO
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Example User");
        requestDTO.setEmail("aaaaaaa@dominio.cl");
        requestDTO.setPassword("ASospe$.uD1ASospe$.uD1");

        BciResponse expectedResponse = new BciResponse("User created successfully.", ResponseCode.CREATED.getResCode(), ResponseCode.CREATED.getResDesc());
        when(userService.createUser(requestDTO)).thenReturn(expectedResponse);

        ResponseEntity<BciResponse> response = userController.createUser(requestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());

        verify(userService).createUser(requestDTO);
    }

    @Test
    public void test_createUser_general_error_NOK() throws Exception {
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Example User");
        requestDTO.setEmail("aaaaaaa@dominio.cl");
        requestDTO.setPassword("ASospe$.uD1ASospe$.uD1");

        UserException expectedException = new UserException(UserException.UserCode.USER_GENERAL_ERROR);
        when(userService.createUser(requestDTO)).thenThrow(expectedException);

        assertThrows(UserException.class, () -> userController.createUser(requestDTO));
        assertEquals(UserException.UserCode.USER_GENERAL_ERROR.getUserCode(), expectedException.getResCode());
        assertEquals(UserException.UserCode.USER_GENERAL_ERROR.name(), expectedException.getMessage());
    }

    @Test
    public void test_createUser_email_format_error_NOK() throws Exception {
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Example User");
        requestDTO.setEmail("aaas");
        requestDTO.setPassword("ASospe$.uD1ASospe$.uD1");

        UserException expectedException = new UserException(UserException.UserCode.USER_BAD_EMAIL_FORMAT);

        when(userService.createUser(requestDTO)).thenThrow(expectedException);

        assertThrows(UserException.class, () -> userController.createUser(requestDTO));
        assertEquals(UserException.UserCode.USER_BAD_EMAIL_FORMAT.getUserCode(), expectedException.getResCode());
        assertEquals(UserException.UserCode.USER_BAD_EMAIL_FORMAT.name(), expectedException.getMessage());
    }

    @Test
    public void test_createUser_password_format_error_NOK() throws Exception {
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Example User");
        requestDTO.setEmail("aaaaaaa@dominio.cl");
        requestDTO.setPassword("123");

        UserException expectedException = new UserException(UserException.UserCode.USER_BAD_PASSWORD_FORMAT);

        when(userService.createUser(requestDTO)).thenThrow(expectedException);

        assertThrows(UserException.class, () -> userController.createUser(requestDTO));
        assertEquals(UserException.UserCode.USER_BAD_PASSWORD_FORMAT.getUserCode(), expectedException.getResCode());
        assertEquals(UserException.UserCode.USER_BAD_PASSWORD_FORMAT.name(), expectedException.getMessage());
    }

    @Test
    public void test_createUser_registered_email_error_NOK() throws Exception {
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName("Example User");
        requestDTO.setEmail("aaaaaaa@dominio.cl");
        requestDTO.setPassword("123");

        UserException expectedException = new UserException(UserException.UserCode.USER_ALREADY_EXISTS);

        when(userService.createUser(requestDTO)).thenThrow(expectedException);

        assertThrows(UserException.class, () -> userController.createUser(requestDTO));
        assertEquals(UserException.UserCode.USER_ALREADY_EXISTS.getUserCode(), expectedException.getResCode());
        assertEquals(UserException.UserCode.USER_ALREADY_EXISTS.name(), expectedException.getMessage());
    }

}
