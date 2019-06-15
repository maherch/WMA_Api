package com.keystone.demo.Controller;

import com.keystone.demo.Entity.ControlExistant;
import com.keystone.demo.service.ControlExistantService;
import com.keystone.demo.exceptionControlExistant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlExistantConroller {

    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private ControlExistantService controlExistantService;

    @RequestMapping("/controlexistant")
    @CrossOrigin(origins = crossOriginUrl)
    public List<ControlExistant> getAllControlExistant() {
        List<ControlExistant> lp=null;
        try {
            lp=controlExistantService.getControlExistant();
        } catch (GetListControlExistantException e) {
            System.out.println(e.getMessage());
        }
        return lp;

    }

    @RequestMapping("/controlexistant/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public ControlExistant getControlExistantId(@PathVariable int id) {
        ControlExistant p=null;
        try {
            p= controlExistantService.getControlExistant(id);
        } catch (GetControlExistantByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;

    }

    @RequestMapping(method = RequestMethod.POST,value="/controlexistant")
    @CrossOrigin(origins = crossOriginUrl)
    public void addControlExistant(@RequestBody ControlExistant controlExistant) {
        try {
            controlExistantService.addControlExistant(controlExistant);
        } catch (AddControlExistantException e) {
            System.out.println(e.getMessage());
        }
    }


    public ControlExistantService getControlExistantService() {
        return controlExistantService;
    }

    public void setControlExistantService(ControlExistantService controlExistantServiceService) {
        this.controlExistantService = controlExistantServiceService;
    }
}
