package com.keystone.demo.Service;

import com.keystone.demo.Repository.ControlExitstantRepository;
import com.keystone.demo.Entity.Control_Existant;
import com.keystone.demo.exceptionControlExistant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ControlExistantService {

    @Autowired
    private ControlExitstantRepository controlExistantRepository;

    public boolean isExiste(int id) {
        return controlExistantRepository.existsById(id);
    }

    public List<Control_Existant> getControlExistant() throws GetListControlExistantException {
        List<Control_Existant> lp =null;
        lp = (List<Control_Existant>) controlExistantRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListControlExistantException("Erreur : Liste Control existant est vide ");
        else
            return lp;
    }

    public Control_Existant getControlExistant(int id) throws GetControlExistantByIdException {
        if(!isExiste(id))
            throw new GetControlExistantByIdException("Erreur : ID incorrect !");
        else
            return controlExistantRepository.findById(id).get();
    }

    public void addControlExistant(Control_Existant controlExistant) throws AddControlExistantException {
        controlExistantRepository.save(controlExistant);
    }

}
