package com.keystone.demo.Controller;


import com.keystone.demo.Entity.Audit;
import com.keystone.demo.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private AuditService auditService;

    @RequestMapping("/audit")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Audit> getAllAudit() {
        List<Audit> lp=null;
        lp=auditService.listerAudit();
        return lp;
    }

    @RequestMapping(method = RequestMethod.POST,value="/audit")
    @CrossOrigin(origins = crossOriginUrl)
    public void addAudit(@RequestBody Audit audit) {
        auditService.addAudit(audit);
    }

    @RequestMapping("/mission/audit/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Audit> getMissionAudit(@PathVariable Long id) {
            List<Audit> lt=null;
        lt=auditService.getAuditByMissionsId(id);
        return lt;
    }



}
