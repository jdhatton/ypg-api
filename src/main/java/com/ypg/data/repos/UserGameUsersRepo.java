package com.ypg.data.repos;

import com.ypg.data.models.UserGameUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGameUsersRepo extends CrudRepository<UserGameUsers, Long> {

    List<UserGameUsers> findById(Long id);
}
