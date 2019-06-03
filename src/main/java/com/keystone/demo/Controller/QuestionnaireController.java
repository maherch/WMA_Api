package com.keystone.demo.Controller;

import com.keystone.demo.Entity.Mission;
import com.keystone.demo.Entity.NonConformite;
import com.keystone.demo.Entity.Question;
import com.keystone.demo.Entity.Questionnaire;
import com.keystone.demo.exceptionMission.*;
import com.keystone.demo.exceptionNc.GetListNcException;
import com.keystone.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionnaireController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private QuestionnaireService questionnaireService;


    @RequestMapping("/questionnaire")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Questionnaire> getAllQuestionnaire() {
        List<Questionnaire> lp=null;
        try {
            lp=questionnaireService.getAllQuestionnaire();
        }

        catch(GetListMissionException nc){
            System.out.println(nc.getMessage());
        }
        return lp;
    }

    @RequestMapping("/questionnaire/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Questionnaire getQuestionnaireId(@PathVariable Long id) {
        Questionnaire p=null;

            p= questionnaireService.getQuestionnaire(id);
        return p;
    }





    @RequestMapping(method = RequestMethod.POST,value="/questionnaire")
    @CrossOrigin(origins = crossOriginUrl)
    public void addQuestionnaire(@RequestBody Questionnaire questionnaire) {

        try {
            questionnaireService.addQuestionnaire(questionnaire);
        } catch (AddMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/questionnaire/{id}")
    public void editQuestionnaire(@RequestBody Questionnaire questionnaire, @PathVariable Long id) {
        try {
            questionnaireService.editQuestionnaire(questionnaire, id);
        } catch (EditMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/questionnaire/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deleteQuestionnaire(@PathVariable Long id) {
        try {
            questionnaireService.deleteQuestionnaire(id);
        } catch (DeleteMissionException e) {
            System.out.println(e.getMessage());
        }
    }


    public QuestionnaireService getQuestionnaireService() {
        return questionnaireService;
    }

    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
}
