package com.keystone.demo.Controller;


import com.keystone.demo.Entity.NonConformite;
import com.keystone.demo.exceptionMission.AddMissionException;
import com.keystone.demo.exceptionNc.AddNcException;
import com.keystone.demo.exceptionNc.GetListNcException;
import com.keystone.demo.service.NonConformiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NonConformiteController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private NonConformiteService nonConformiteService;

    @RequestMapping("/nc")
    @CrossOrigin(origins = crossOriginUrl)
    public List<NonConformite> getAllNc() {
        List<NonConformite> lp=null;
        try {
            lp=nonConformiteService.listerNc();
        }
        catch(GetListNcException nc){
            System.out.println(nc.getMessage());
        }
        return lp;
    }


    @RequestMapping(method = RequestMethod.POST,value="/nc")
    @CrossOrigin(origins = crossOriginUrl)
    public void addNc(@RequestBody NonConformite nonConformite) {
        try {
            nonConformiteService.addNc(nonConformite);
        } catch (AddNcException e) {
            System.out.println(e.getMessage());
        }
    }


    @RequestMapping("/controle/nc/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public List<NonConformite> getControleNc(@PathVariable Long id) {
        List<NonConformite> lt=null;
        lt=nonConformiteService.getNcByControleId(id);
        return lt;
    }







}
