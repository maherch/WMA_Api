package com.keystone.demo.service;

import com.keystone.demo.Entity.GestionTaches;
import com.keystone.demo.Repository.GestionTachesRepository;
import com.keystone.demo.exceptionGestionTaches.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionTachesService {

    @Autowired
    private GestionTachesRepository gestionTachesRepository;

    public boolean isExiste(int id) {
        return gestionTachesRepository.existsById(id);
    }

    public List<GestionTaches> getGestionTaches() throws GetListGestionTachesException {
        List<GestionTaches> lp =null;
        lp = (List<GestionTaches>) gestionTachesRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListGestionTachesException("Erreur : Liste gestion taches est vide ");
        else
            return lp;
    }

    public GestionTaches getGestionTaches(int id) throws GetGestionTachesByIdException {
        if(!isExiste(id))
            throw new GetGestionTachesByIdException("Erreur : ID incorrect !");
        else
            return gestionTachesRepository.findById(id).get();
    }

    public void addGestionTaches(GestionTaches gestionTaches) throws AddGestionTachesException {
        gestionTachesRepository.save(gestionTaches);
    }

    public void editGestionTaches(GestionTaches gestionTaches, int id) throws EditGestionTachesException {
        if(!isExiste(id))
            throw new EditGestionTachesException("Erreur : ID incorrect !");
        else {
            gestionTachesRepository.deleteById(id);
            gestionTachesRepository.save(gestionTaches);
        }
    }

    public void deleteGestionTaches(int id) throws DeleteGestionTachesException {
        if(!isExiste(id))
            throw new DeleteGestionTachesException("Erreur : ID incorrect");
        else
            gestionTachesRepository.deleteById(id);
    }

}
