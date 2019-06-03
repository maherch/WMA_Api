package com.keystone.demo.service;


import com.keystone.demo.Entity.Mission;
import com.keystone.demo.Entity.Question;
import com.keystone.demo.Entity.Questionnaire;
import com.keystone.demo.Repository.QuestionRepository;
import com.keystone.demo.Repository.QuestionnaireRepository;
import com.keystone.demo.exceptionMission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public boolean isExiste(Long id) {
        return questionnaireRepository.existsById(id);
    }


    public List<Questionnaire> getAllQuestionnaire() throws GetListMissionException {
        List<Questionnaire> lp =null;
        lp = (List<Questionnaire>) questionnaireRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListMissionException("Erreur : Liste questionnaire est vide ");
        else
            return lp;
    }


    public Questionnaire getQuestionnaire(Long id) {
            return questionnaireRepository.findById(id).get();
    }




    public void addQuestionnaire(Questionnaire questionnaire) throws AddMissionException {
        questionnaireRepository.save(questionnaire);
    }

    public void editQuestionnaire(Questionnaire questionnaire, Long id) throws EditMissionException {
        if(!isExiste(id))
            throw new EditMissionException("Erreur : ID incorrect !");
        else {
            questionnaireRepository.save(questionnaire);
        }
    }

    public void deleteQuestionnaire(Long id) throws DeleteMissionException {
        if(!isExiste(id))
            throw new DeleteMissionException("Erreur : ID incorrect");
        else
            questionnaireRepository.deleteById(id);
    }





    }






