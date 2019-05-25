package com.keystone.demo.Repository;


import com.keystone.demo.Entity.Control_Existant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ControlExitstantRepository  extends CrudRepository<Control_Existant,Integer> {
}
