package cl.bci.javatest.jpa.repository.write;

import cl.bci.javatest.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryWrite extends JpaRepository<User, UUID> {
    User save(User user);
}
