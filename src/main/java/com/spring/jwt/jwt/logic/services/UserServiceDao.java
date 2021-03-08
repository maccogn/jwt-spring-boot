package com.spring.jwt.jwt.logic.services;

import com.spring.jwt.jwt.logic.exceptions.ETAuthException;
import com.spring.jwt.jwt.model.User;

public interface UserServiceDao {

    User validateUser(String email, String password) throws ETAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException;

}
