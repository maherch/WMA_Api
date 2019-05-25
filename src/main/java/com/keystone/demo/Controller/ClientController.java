package com.keystone.demo.Controller;

import com.keystone.demo.Entity.Client;
import com.keystone.demo.exceptionClient.*;
import com.keystone.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ClientController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping("/client")
    public List<Client> getAllClients() {
        List<Client> lp=null;
        try {
            lp=clientService.getclients();
        } catch (GetListClientException e) {
            System.out.println(e.getMessage());
        }
        return lp;
    }

    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping("/client/{id}")
    public Client getClientId(@PathVariable Long id) {
        Client p=null;
        try {
            p= clientService.getClient(id);
        } catch (GetClientByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;
    }

    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(method = RequestMethod.POST,value="/client")
    public void addClient(@RequestBody Client client) {
        try {
            clientService.addClient(client);
        } catch (AddClientException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/client/{id}")
    public void editClient(@RequestBody Client client, @PathVariable Long id) {
        try {
            clientService.editClient(client, id);
        } catch (EditClientException e) {
            System.out.println(e.getMessage());
        }
    }

    @CrossOrigin(origins = crossOriginUrl)
    @RequestMapping(method = RequestMethod.DELETE,value="/client/{id}")
    public void deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
        } catch (DeleteClientException e) {
            System.out.println(e.getMessage());
        }
    }









}
