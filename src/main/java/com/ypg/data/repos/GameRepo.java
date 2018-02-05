package com.ypg.data.repos;

import com.ypg.data.models.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepo  extends CrudRepository<Game, Long> {

    List<Game> findById(Long id);
}
