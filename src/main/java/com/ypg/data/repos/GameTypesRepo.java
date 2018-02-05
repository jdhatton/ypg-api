package com.ypg.data.repos;

import com.ypg.data.models.GameTypes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameTypesRepo extends CrudRepository<GameTypes, Long> {

    List<GameTypes> findById(Long id);
}
