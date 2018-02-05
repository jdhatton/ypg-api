package com.ypg.data.repos;

import com.ypg.data.models.UserGameCustomizations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGameCustomizationsRepo extends CrudRepository<UserGameCustomizations, Long> {

    List<UserGameCustomizations> findById(Long id);
}