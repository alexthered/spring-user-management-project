package com.alexthered.me.service;

import com.alexthered.me.domain.User;
import com.alexthered.me.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hd on 04.04.17.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * save an user to the database
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * find all users in the database
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * find an user by his email
     * @param email
     * @return user if existing, null otherwise
     */
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    /**
     * find an user by his user Id
     * @param id
     * @return user if existing, null otherwise
     */
    public User findById(Long id){
        return userRepository.findOne(id);
    }


    /**
     * check if the user with queried email has existed already
     * @param email
     * @return true if user with the same email has existed and false otherwise
     */
    public boolean isExistingUser(String email){
        Long count = userRepository.countByEmail(email);

        return count > 0;
    }

    /**
     * delete an user from database
     * @param user
     */
    public void delete(User user){
        userRepository.delete(user);
    }
}
