package cl.bci.javatest.jpa.repository.impl;

import cl.bci.javatest.jpa.entity.User;
import cl.bci.javatest.jpa.repository.UserRepository;
import cl.bci.javatest.jpa.repository.read.UserRepositoryRead;
import cl.bci.javatest.jpa.repository.write.UserRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserRepositoryWrite userRepositoryWrite;

    @Autowired
    UserRepositoryRead userRepositoryRead;

    @Override
    public User save(User user) {
        return userRepositoryWrite.save(user);
    }

    @Override
    public User getUserByEmail(String email){return userRepositoryRead.getUserByEmail(email);}

    @Override
    public List<User> listActiveUsers(){return userRepositoryRead.getAllByActiveIsTrue();}
}
