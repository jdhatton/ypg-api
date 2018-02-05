package com.ypg.data.repos;

import com.ypg.data.models.GameStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameStatusRepo extends CrudRepository<GameStatus, Long> {

    List<GameStatus> findById(Long id);
}
