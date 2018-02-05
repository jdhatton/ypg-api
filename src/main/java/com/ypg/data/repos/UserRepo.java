package com.ypg.data.repos;

import com.ypg.data.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findById(Long id);
}