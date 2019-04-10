package com.keystone.demo.dao;

import com.keystone.demo.entities.Auditeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditeurRepository extends JpaRepository<Auditeur,Long> {

}
