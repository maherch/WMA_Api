package com.keystone.demo.service;

import com.keystone.demo.Entity.Categorie;
import com.keystone.demo.Repository.CategorieRepository;

import com.keystone.demo.exceptionCategorie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public boolean isExiste(int id) {
        return categorieRepository.existsById(id);
    }

    public List<Categorie> getCategories() throws GetListCategorieException {
        List<Categorie> lp =null;
        lp = (List<Categorie>) categorieRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListCategorieException("Erreur : Liste categorie est vide ");
        else
            return lp;
    }

    public Categorie getCategorie(int id) throws GetCategorieByIdException {
        if(!isExiste(id))
            throw new GetCategorieByIdException("Erreur : ID incorrect !");
        else
            return categorieRepository.findById(id).get();
    }

    public void addCategorie(Categorie categorie) throws AddCategorieException {

            categorieRepository.save(categorie);


    }

    public void editCategorie(Categorie categorie, int id) throws EditCategorieException {
        if(!isExiste(id))
            throw new EditCategorieException("Erreur : ID incorrect !");
        else {
            categorieRepository.deleteById(id);
            categorieRepository.save(categorie);
        }
    }

    public void deleteCategorie(int id) throws DeleteCategorieException {
        if(!isExiste(id))
            throw new DeleteCategorieException("Erreur : ID incorrect");
        else
            categorieRepository.deleteById(id);
    }

    public void deleteAllCategorie() throws DeleteAllException {
        if(categorieRepository.count()==0)
            throw new DeleteAllException("Erreur : il n'y a pas des categories pour effacer !" );
        else
            categorieRepository.deleteAll();
    }


}
