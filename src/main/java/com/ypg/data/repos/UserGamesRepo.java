package com.ypg.data.repos;

import com.ypg.data.models.UserGames;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGamesRepo extends CrudRepository<UserGames, Long> {

    List<UserGames> findById(Long id);
}
