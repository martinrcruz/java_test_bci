package cl.bci.javatest.dto.request;

import cl.bci.javatest.jpa.entity.Phone;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequestDTO {
    private String name;

    private String email;

    private String password;

    private List<Phone> phones;
}
