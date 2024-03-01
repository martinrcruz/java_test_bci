package cl.bci.javatest.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserResponseDTO {
    private String id;
    private String created_at;
    private String last_modified_at;
    private String last_login_at;
    private String token;
    private boolean active;
}
