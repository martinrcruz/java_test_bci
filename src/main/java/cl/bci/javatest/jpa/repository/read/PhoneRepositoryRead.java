package cl.bci.javatest.jpa.repository.read;

import cl.bci.javatest.jpa.entity.Phone;
import cl.bci.javatest.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepositoryRead extends JpaRepository<Phone, UUID> {
}
