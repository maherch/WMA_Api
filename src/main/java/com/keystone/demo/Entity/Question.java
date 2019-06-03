package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private Long QuestId;
    private String question;
    private String reponse;

    public Question() {
    }

    public Question(String question, String reponse,Long id) {
        this.question = question;
        this.reponse = reponse;
        this.QuestId=id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestId() {
        return QuestId;
    }

    public void setQuestId(Long questId) {
        QuestId = questId;
    }
}




