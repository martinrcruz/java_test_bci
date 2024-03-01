package cl.bci.javatest.dto.response;

import cl.bci.javatest.jpa.entity.Phone;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ListUsersResponseDTO {
    private String id;
    private String name;
    private String email;
    private List<Phone> phones;
    private String created_at;
    private String last_modified_at;
    private String last_login_at;
}
