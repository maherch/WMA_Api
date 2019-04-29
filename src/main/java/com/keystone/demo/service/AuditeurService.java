package com.keystone.demo.service;

import com.keystone.demo.Repository.AuditeurRepository;
import com.keystone.demo.Entity.Auditeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuditeurService implements service{

  @Autowired
   AuditeurRepository auditRep;


    @Override
    public void insertAuditeur(Auditeur a) {
      auditRep.save(a);
    }

    @Override
    public Auditeur FindById(Long id) {
        return auditRep.findById(id).get();
    }

    @Override
    public void update(Auditeur auditeur, Long id) {
        auditRep.deleteById(id);
        auditRep.save(auditeur);
    }

    @Override
    public void delete(Long id) {
        auditRep.deleteById(id);
    }

    @Override
    public List<Auditeur> listing() {
        List<Auditeur> lrs =null;
        lrs = (List<Auditeur>) auditRep.findAll();
            return lrs;
    }
}
