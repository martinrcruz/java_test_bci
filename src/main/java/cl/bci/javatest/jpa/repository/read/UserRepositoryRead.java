package cl.bci.javatest.jpa.repository.read;

import cl.bci.javatest.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryRead extends JpaRepository<User, UUID> {
    User getUserByEmail(String email);
    List<User> getAllByActiveIsTrue();
}
