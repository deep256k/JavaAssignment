package com.yubi.RHSB.dao.user;

import com.yubi.RHSB.model.User;
import com.yubi.RHSB.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        if (userRepository.count() == 0) {
            userRepository.save(new User("admin", "admin", "admin"));
            userRepository.save(new User("user", "user", "user"));
        }
    }

    @Override
    public User findByUserId(String userId) {
        return null;
    }

    @Override
    public User findUserByName(String username) {
      return   userRepository.findByUsername(username);
    }
}
