package com.keystone.demo.service;


import com.keystone.demo.Entity.Audit;
import com.keystone.demo.Repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public void addAudit(Audit audit) {
        auditRepository.save(audit);
    }

    public void saveAudit(Audit audit)  {
        auditRepository.save(audit);
    }

    public List<Audit> listerAudit(){
        return auditRepository.findAll();
    }

    public List<Audit> getAuditByMissionsId(Long idMission) {
        List<Audit> lp = null;
        List<Audit> lp2 = new ArrayList<Audit>();
        lp = (List<Audit>) auditRepository.findAll();
        if (lp != null && !lp.isEmpty()) {
            for (Audit sg : lp) {
                if (sg.getIdMission() == idMission) {
                    lp2.add(sg);
                }
            }
        }
        return lp2;
    }




}
