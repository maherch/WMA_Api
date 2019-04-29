package com.keystone.demo.service;

import com.keystone.demo.Entity.Auditeur;

import java.util.List;

public interface service {
    public void insertAuditeur(Auditeur a);
    public Auditeur FindById(Long id);

   public void update(Auditeur auditeur, Long id);

    public void delete(Long id);
    public List<Auditeur> listing();
}
