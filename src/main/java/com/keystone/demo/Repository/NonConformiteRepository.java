package com.keystone.demo.Repository;

import com.keystone.demo.Entity.NonConformite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonConformiteRepository extends JpaRepository<NonConformite,Long> {

}
