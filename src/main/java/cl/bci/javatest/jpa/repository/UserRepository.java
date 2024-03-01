package cl.bci.javatest.jpa.repository;

import cl.bci.javatest.jpa.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository {
    User save(User user);
    User getUserByEmail(String email);
    List<User> listActiveUsers();
}
