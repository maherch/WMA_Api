package com.keystone.demo.Controller;

import com.keystone.demo.Entity.Auditeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.keystone.demo.service.AuditeurService;

import java.util.List;

@RestController
public class AuditeurController {


    static final String crossOriginUrl="http://localhost:4200";

    @Autowired
    private AuditeurService auditeurService;


    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(method = RequestMethod.POST,value="/auditeur")
    public void AjoutAuditeur(@RequestBody Auditeur auditeur){
        auditeurService.insertAuditeur(auditeur);
    }


    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(value="/auditeur", method = RequestMethod.GET)
    public List<Auditeur> getAllAuditeurs(){
        List<Auditeur> ladr=null;
        try {
            ladr=auditeurService.listing();
        }
        catch (Exception e){
            System.out.println("erreur");
        }
        return ladr;
    }


    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(method = RequestMethod.PUT,value="/auditeur/{id}")
    public void editAuditeur(@RequestBody Auditeur auditeur, @PathVariable Long id) {
        try {
            auditeurService.update(auditeur, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(method = RequestMethod.DELETE,value="/auditeur/{id}")
    public void deleteAuditeur(@PathVariable Long id) {
        try {
            auditeurService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping("/auditeur/{id}")
    public Auditeur getAuditeurById(@PathVariable Long id) {
        Auditeur auditeur = null;
        auditeur = auditeurService.FindById(id);
        return auditeur;
    }






  /*  @GetMapping("/api/messages")
    public List<String> getMessages(Principal principal) {
        // handle request
    }

    @Configuration
    public class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.oauth2ResourceServer().jwt();
        }
    } */




}
