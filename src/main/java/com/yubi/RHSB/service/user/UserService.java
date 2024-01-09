package com.yubi.RHSB.service.user;

import com.yubi.RHSB.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void addUser(User user);

    User getUserById(int userId);

    void updateUser(User user);

    void deleteUser(int userId);

    User validateUser(String userName, String Password) throws Exception;

    User findUserByName(String username);
//    List<User> getAllUsers();
}

