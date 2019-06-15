package com.keystone.demo.Repository;

import com.keystone.demo.Entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit,Long> {
}
