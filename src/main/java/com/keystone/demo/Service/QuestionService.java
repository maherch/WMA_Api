package com.keystone.demo.service;

import com.keystone.demo.Entity.Question;
import com.keystone.demo.Entity.Questionnaire;
import com.keystone.demo.Repository.QuestionRepository;
import com.keystone.demo.exceptionMission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionRepository questionRepository;


    public boolean isExiste(Long id) {
        return questionRepository.existsById(id);
    }


    public List<Question> getAllQuestins() throws GetListMissionException {
        List<Question> lp = null;
        lp = (List<Question>) questionRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListMissionException("Erreur : Liste questions est vide ");
        else
            return lp;
    }


    public Question getQuestion(Long id) throws GetMissionByIdException {
        if (!isExiste(id))
            throw new GetMissionByIdException("Erreur : ID incorrect !");
        else
            return questionRepository.findById(id).get();
    }

    public void addQuestion(Question question) throws AddMissionException {
        questionRepository.save(question);
    }

    public void editQuestion(Question question, Long id) throws EditMissionException {
        if (!isExiste(id))
            throw new EditMissionException("Erreur : ID incorrect !");
        else {
            questionRepository.save(question);
        }
    }


    public void deleteQuestion(Long id) throws DeleteMissionException {
        if (!isExiste(id))
            throw new DeleteMissionException("Erreur : ID incorrect");
        else
            questionRepository.deleteById(id);
    }

    public List<Question> getQuestionsByQuestionnaireId(Long idQuestion) {
        List<Question> lp = null;
        List<Question> lp2 = new ArrayList<Question>();
        lp = (List<Question>) questionRepository.findAll();
        if (lp != null && !lp.isEmpty()) {
            for (Question question : lp) {
                if (question.getQuestId() == idQuestion) {
                    lp2.add(question);
                }
            }
        }

    return lp2;
    }
}