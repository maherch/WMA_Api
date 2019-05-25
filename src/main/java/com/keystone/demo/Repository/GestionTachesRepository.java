package com.keystone.demo.Repository;


import com.keystone.demo.Entity.Gestion_Taches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface GestionTachesRepository extends CrudRepository<Gestion_Taches,Integer> {
}
