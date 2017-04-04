package com.alexthered.me.repository;

import com.alexthered.me.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hd on 03.04.17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
