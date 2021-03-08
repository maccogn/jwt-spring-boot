package com.spring.jwt.jwt.logic.services;

import com.spring.jwt.jwt.logic.repositories.UserRepositoryDao;
import com.spring.jwt.jwt.model.User;
import com.spring.jwt.jwt.logic.exceptions.ETAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceDaoImp implements UserServiceDao{

    @Autowired
    UserRepositoryDao userRepository;

    @Override
    public User validateUser(String email, String password) throws ETAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new ETAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0)
            throw new ETAuthException("Email already in use");
        Integer userId = userRepository.create(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }
}
