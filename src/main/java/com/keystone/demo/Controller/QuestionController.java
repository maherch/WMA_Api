package com.keystone.demo.Controller;


import com.keystone.demo.Entity.Question;
import com.keystone.demo.Entity.Questionnaire;
import com.keystone.demo.exceptionMission.*;
import com.keystone.demo.service.QuestionService;
import com.keystone.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/question")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Question> getAllQuestions() {
        List<Question> lp=null;
        try {
            lp=questionService.getAllQuestins();
        }

        catch(GetListMissionException nc){
            System.out.println(nc.getMessage());
        }
        return lp;
    }

    @RequestMapping("/question/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Question getQuestionId(@PathVariable Long id) {
        Question p=null;
        try {
            p= questionService.getQuestion(id);
        } catch (GetMissionByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;
    }


    @RequestMapping(method = RequestMethod.POST,value="/question")
    @CrossOrigin(origins = crossOriginUrl)
    public void addQuestion(@RequestBody Question question) {

        try {
            questionService.addQuestion(question);
        } catch (AddMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/question/{id}")
    public void editQuestion(@RequestBody Question question, @PathVariable Long id) {
        try {
            questionService.editQuestion(question, id);
        } catch (EditMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/question/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deleteQuestion(@PathVariable Long id) {
        try {
            questionService.deleteQuestion(id);
        } catch (DeleteMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping("/questionnaire/questions/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Question> getQuestionnaireQuestion(@PathVariable Long id) {
        List<Question> lt=null;
        lt=questionService.getQuestionsByQuestionnaireId(id);
        return lt;
    }




}
