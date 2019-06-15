package com.keystone.demo.Controller;

import com.keystone.demo.Entity.GestionTaches;
import com.keystone.demo.service.GestionTachesService;
import com.keystone.demo.exceptionGestionTaches.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GestionTachesController {

    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private GestionTachesService gestionTachesService;

    @RequestMapping("/gestiontaches")
    @CrossOrigin(origins = crossOriginUrl)
    public List<GestionTaches> getAllGestionTaches() {
        List<GestionTaches> lp=null;
        try {
            lp=gestionTachesService.getGestionTaches();
        } catch (GetListGestionTachesException e) {
            System.out.println(e.getMessage());
        }
        return lp;

    }

    @RequestMapping("/gestiontaches/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public GestionTaches getGestionTachesId(@PathVariable int id) {
        GestionTaches p=null;
        try {
            p= gestionTachesService.getGestionTaches(id);
        } catch (GetGestionTachesByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;

    }

    @RequestMapping(method = RequestMethod.POST,value="/gestiontaches")
    @CrossOrigin(origins = crossOriginUrl)
    public void addGestionTaches(@RequestBody GestionTaches gestionTaches) {
        try {
            gestionTachesService.addGestionTaches(gestionTaches);
        } catch (AddGestionTachesException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/gestiontaches/{id}")
    //@CrossOrigin(origins = crossOriginUrl)
    public void editGestionTaches(@RequestBody GestionTaches gestionTaches, @PathVariable int id) {
        try {
            gestionTachesService.editGestionTaches(gestionTaches, id);
        } catch (EditGestionTachesException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/gestiontaches/{id}")
    //@CrossOrigin(origins = crossOriginUrl)
    public void deleteGestionTaches(@PathVariable int id) {
        try {
            gestionTachesService.deleteGestionTaches(id);
        } catch (DeleteGestionTachesException e) {
            System.out.println(e.getMessage());
        }
    }

    public GestionTachesService getGestionTachesService() {
        return gestionTachesService;
    }

    public void setGestionTachesService(GestionTachesService gestionTachesService) {
        this.gestionTachesService = gestionTachesService;
    }
}
