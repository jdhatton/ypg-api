package com.ypg.data.repos.games;

import com.ypg.data.models.games.PlayableGameNFL;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayableGameNFLRepo extends CrudRepository<PlayableGameNFL, Long> {

    List<PlayableGameNFL> findById(Long id);
}