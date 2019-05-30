package com.keystone.demo.service;

import com.keystone.demo.Entity.Client;
import com.keystone.demo.Repository.ClientRepository;
import com.keystone.demo.exceptionClient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    public boolean isExiste(Long id) {
        return clientRepository.existsById(id);
    }

    public List<Client> getclients() throws GetListClientException {
        List<Client> lp =null;
        lp = (List<Client>) clientRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListClientException("Erreur : Liste mission est vide ");
        else
            return lp;
    }

    public Client getClient(Long id) throws GetClientByIdException {
        if(!isExiste(id))
            throw new GetClientByIdException("Erreur : ID incorrect !");
        else
            return clientRepository.findById(id).get();
    }

    public void addClient(Client client) throws AddClientException {
        clientRepository.save(client);
    }

    public void editClient(Client cl, Long id) throws EditClientException {
        if(!isExiste(id))
            throw new EditClientException("Erreur : ID incorrect !");
        else {
            clientRepository.deleteById(id);
            clientRepository.save(cl);
        }
    }

    public void deleteClient(Long id) throws DeleteClientException {
        if(!isExiste(id))
            throw new DeleteClientException("Erreur : ID incorrect");
        else
            clientRepository.deleteById(id);
    }

    public void deleteAllClients() throws DeleteAllException {
        if(clientRepository.count()==0)
            throw new DeleteAllException("Erreur : il n'y a pas des missions pour effacer !" );
        else
            clientRepository.deleteAll();
    }
}
