package com.keystone.demo.Controller;

import com.keystone.demo.Entity.Categorie;
import com.keystone.demo.service.CategorieService;

import com.keystone.demo.exceptionCategorie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private CategorieService categorieService;


    @RequestMapping("/categorie")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Categorie> getAllCategories() {
        List<Categorie> lp=null;
        try {
            lp=categorieService.getCategories();
        } catch (GetListCategorieException e) {
            System.out.println(e.getMessage());
        }
        return lp;

    }

    @RequestMapping("/categorie/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Categorie getCategorieId(@PathVariable int id) {
        Categorie p=null;
        try {
            p= categorieService.getCategorie(id);
        } catch (GetCategorieByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;

    }

    @RequestMapping(method = RequestMethod.POST,value="/categorie")
    @CrossOrigin(origins = crossOriginUrl)
    public void addCategorie(@RequestBody Categorie categorie) {
        try {
            categorieService.addCategorie(categorie);
        } catch (AddCategorieException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/categorie/{id}")
    //@CrossOrigin(origins = crossOriginUrl)
    public void editCategorie(@RequestBody Categorie categorie, @PathVariable int id) {
        try {
            categorieService.editCategorie(categorie, id);
        } catch (EditCategorieException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/categorie/{id}")
    //@CrossOrigin(origins = crossOriginUrl)
    public void deleteCategorie(@PathVariable int id) {
        try {
            categorieService.deleteCategorie(id);
        } catch (DeleteCategorieException e) {
            System.out.println(e.getMessage());
        }
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllCategorie")
    //CrossOrigin(origins = crossOriginUrl)
    public void deleteAllCategorie() {
        try {
            categorieService.deleteAllCategorie();
        } catch (DeleteAllException e) {
            System.out.println(e.getMessage());
        }
    }

    public CategorieService getCategorieService() {
        return categorieService;
    }

    public void setCategorieService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

}