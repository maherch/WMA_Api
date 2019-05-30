package com.keystone.demo.Service;

import com.keystone.demo.Repository.ControlExitstantRepository;
import com.keystone.demo.Entity.ControlExistant;
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

    public List<ControlExistant> getControlExistant() throws GetListControlExistantException {
        List<ControlExistant> lp =null;
        lp = (List<ControlExistant>) controlExistantRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListControlExistantException("Erreur : Liste Control existant est vide ");
        else
            return lp;
    }

    public ControlExistant getControlExistant(int id) throws GetControlExistantByIdException {
        if(!isExiste(id))
            throw new GetControlExistantByIdException("Erreur : ID incorrect !");
        else
            return controlExistantRepository.findById(id).get();
    }

    public void addControlExistant(ControlExistant controlExistant) throws AddControlExistantException {
        controlExistantRepository.save(controlExistant);
    }

}
