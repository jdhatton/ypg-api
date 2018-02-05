package com.ypg.data.repos;

import com.ypg.data.models.GameDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameDetailsRepo  extends CrudRepository<GameDetails, Long> {

    List<GameDetails> findById(Long id);
}
