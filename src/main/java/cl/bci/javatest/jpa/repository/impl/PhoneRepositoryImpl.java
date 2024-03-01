package cl.bci.javatest.jpa.repository.impl;

import cl.bci.javatest.jpa.entity.Phone;
import cl.bci.javatest.jpa.repository.PhoneRepository;
import cl.bci.javatest.jpa.repository.read.PhoneRepositoryRead;
import cl.bci.javatest.jpa.repository.write.PhoneRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneRepositoryImpl implements PhoneRepository {
    @Autowired
    PhoneRepositoryWrite phoneRepositoryWrite;

    @Autowired
    PhoneRepositoryRead phoneRepositoryRead;

    @Override
    public Phone save(Phone phone) {
        return phoneRepositoryWrite.save(phone);
    }
}
