package cl.bci.javatest.jpa.repository;

import cl.bci.javatest.jpa.entity.Phone;
import cl.bci.javatest.jpa.entity.User;

public interface PhoneRepository {
    Phone save(Phone phone);
}
