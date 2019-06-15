package com.keystone.demo.Controller;


import com.keystone.demo.Entity.Suggestion;
import com.keystone.demo.service.NonConformiteService;
import com.keystone.demo.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuggestionController {
    static final String crossOriginUrl = "http://localhost:4200";


    @Autowired
    private SuggestionService suggestionService;

    @RequestMapping("/suggestion")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Suggestion> getAllNc() {
        List<Suggestion> lp=null;
            lp=suggestionService.listerSuggestions();
        return lp;
    }


    @RequestMapping(method = RequestMethod.POST,value="/suggestion")
    @CrossOrigin(origins = crossOriginUrl)
    public void addSuggestion(@RequestBody Suggestion suggestion) {
            suggestionService.addSuggestion(suggestion);
        }



    @RequestMapping("/nc/suggestion/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Suggestion> getNcSuggestions(@PathVariable Long id) {
        List<Suggestion> lt=null;
        lt=suggestionService.getSuggestionByNCId(id);
        return lt;
    }




}
