package com.ypg.data.repos;

import com.ypg.data.models.UserCookie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCookieRepo extends CrudRepository<UserCookie, Long> {

    List<UserCookie> findById(Long id);
}
