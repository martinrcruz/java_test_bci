package cl.bci.javatest.jpa.repository.write;

import cl.bci.javatest.jpa.entity.Phone;
import cl.bci.javatest.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepositoryWrite extends JpaRepository<Phone, UUID> {
    Phone save(Phone phone);
}
