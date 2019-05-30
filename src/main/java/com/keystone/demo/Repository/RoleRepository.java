package com.keystone.demo.Repository;

import java.util.Optional;

import com.keystone.demo.Entity.Role;
import com.keystone.demo.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}