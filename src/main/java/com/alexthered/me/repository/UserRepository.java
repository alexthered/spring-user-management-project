package com.alexthered.me.repository;

import com.alexthered.me.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by hd on 03.04.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
