package com.ypg.data.repos;

import com.ypg.data.models.UserGame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGameRepo extends CrudRepository<UserGame, Long> {

    List<UserGame> findById(Long id);
}
