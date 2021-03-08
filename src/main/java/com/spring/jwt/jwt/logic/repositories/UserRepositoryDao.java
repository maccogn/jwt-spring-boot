package com.spring.jwt.jwt.logic.repositories;

import com.spring.jwt.jwt.model.User;
import com.spring.jwt.jwt.logic.exceptions.ETAuthException;

public interface UserRepositoryDao {

    Integer createUser(String firstName, String lastName, String  email, String password) throws ETAuthException;

    User findByEmailAndPassword(String email, String password) throws ETAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userID);
}
