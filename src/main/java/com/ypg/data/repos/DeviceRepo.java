package com.ypg.data.repos;

import com.ypg.data.models.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepo extends CrudRepository<Device, Long> {

    List<Device> findById(Long id);
}
