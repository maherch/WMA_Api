package com.keystone.demo.Controller;


import com.keystone.demo.Entity.NonConformite;
import com.keystone.demo.exceptionNc.GetListNcException;
import com.keystone.demo.service.NonConformiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/nc",method = RequestMethod.PUT)
    @CrossOrigin(origins = crossOriginUrl)
    public void editNc(){

    }





}
