package com.keystone.demo.Repository;

import com.keystone.demo.Entity.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4202")
public interface MissionRepository extends CrudRepository<Mission,Integer> {
}
