package com.ypg.data.repos;

import com.ypg.data.models.RealTimeFeeds;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RealTimeFeedsRepo extends CrudRepository<RealTimeFeeds, Long> {

    List<RealTimeFeeds> findById(Long id);
}