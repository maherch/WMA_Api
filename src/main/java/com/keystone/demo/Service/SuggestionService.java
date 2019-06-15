package com.keystone.demo.service;


import com.keystone.demo.Entity.Suggestion;
import com.keystone.demo.Repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;


    public void addSuggestion(Suggestion suggestion) {
        suggestionRepository.save(suggestion);
    }

    public void saveSuggestion(Suggestion suggestion)  {
        suggestionRepository.save(suggestion);
    }

    public List<Suggestion> listerSuggestions(){
        return suggestionRepository.findAll();
    }

    public List<Suggestion> getSuggestionByNCId(Long idNc) {
        List<Suggestion> lp = null;
        List<Suggestion> lp2 = new ArrayList<Suggestion>();
        lp = (List<Suggestion>) suggestionRepository.findAll();
        if (lp != null && !lp.isEmpty()) {
            for (Suggestion sg : lp) {
                if (sg.getIdNc() == idNc) {
                    lp2.add(sg);
                }
            }
        }
        return lp2;
    }


}
