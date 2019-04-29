package com.keystone.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.keystone.demo.Entity.Categorie;


@Repository
@CrossOrigin(origins = "http://localhost:4202")
public interface CategorieRepository extends CrudRepository<Categorie,Integer>{

}
