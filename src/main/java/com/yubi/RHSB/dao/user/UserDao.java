package com.yubi.RHSB.dao.user;

import com.yubi.RHSB.model.User;

public interface UserDao {
    User findByUserId(String userId);

    User findUserByName(String username);

}
