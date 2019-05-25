package com.keystone.demo.Repository;

import com.keystone.demo.Entity.Auditeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditeurRepository extends JpaRepository<Auditeur,Long> {

}
