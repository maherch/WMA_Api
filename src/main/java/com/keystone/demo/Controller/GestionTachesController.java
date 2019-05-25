package com.keystone.demo.Controller;

import com.keystone.demo.Entity.Gestion_Taches;
import com.keystone.demo.Service.GestionTachesService;
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
    public List<Gestion_Taches> getAllGestionTaches() {
        List<Gestion_Taches> lp=null;
        try {
            lp=gestionTachesService.getGestionTaches();
        } catch (GetListGestionTachesException e) {
            System.out.println(e.getMessage());
        }
        return lp;

    }

    @RequestMapping("/gestiontaches/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Gestion_Taches getGestionTachesId(@PathVariable int id) {
        Gestion_Taches p=null;
        try {
            p= gestionTachesService.getGestionTaches(id);
        } catch (GetGestionTachesByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;

    }

    @RequestMapping(method = RequestMethod.POST,value="/gestiontaches")
    @CrossOrigin(origins = crossOriginUrl)
    public void addGestionTaches(@RequestBody Gestion_Taches gestionTaches) {
        try {
            gestionTachesService.addGestionTaches(gestionTaches);
        } catch (AddGestionTachesException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/gestiontaches/{id}")
    //@CrossOrigin(origins = crossOriginUrl)
    public void editGestionTaches(@RequestBody Gestion_Taches gestionTaches, @PathVariable int id) {
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
