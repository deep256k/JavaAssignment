package com.yubi.RHSB.service.user;

import com.yubi.RHSB.repository.user.UserRepository;
import com.yubi.RHSB.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;  // Assuming you have a UserRepository interface


    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findById(String.valueOf(userId)).orElse(null);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteById(String.valueOf(userId));
    }

    @Override
    public User validateUser(String userName, String password) throws Exception {
        User user = userDao.findByUsername(userName);
        if (user == null) throw new Exception("User not found");

        if (!password.equals(user.getPassword())) throw new Exception("Incorrect password");

        return user;

    }

    @Override
    public User findUserByName(String username){
        return userDao.findByUsername(username);
    }

}

