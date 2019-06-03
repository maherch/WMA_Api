package com.keystone.demo.service;

import com.keystone.demo.Entity.NonConformite;
import com.keystone.demo.Repository.NonConformiteRepository;
import com.keystone.demo.exceptionNc.AddNcException;
import com.keystone.demo.exceptionNc.GetListNcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonConformiteService {

    @Autowired
    private NonConformiteRepository nonConformiteRepository;

    public void addNc(NonConformite nonConformite) throws AddNcException {
        nonConformiteRepository.save(nonConformite);
    }

    public void saveNc(NonConformite nonConformite) throws AddNcException {
        nonConformiteRepository.save(nonConformite);
    }

    public List<NonConformite> listerNc() throws GetListNcException {
        return nonConformiteRepository.findAll();
    }











}
