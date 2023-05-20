package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.entity.Client;
import ru.theboys.deliverypointratingdataservice.service.ClientService;

import java.util.List;
@RestController
@RequestMapping("clientes")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClientes() {
        return this.clientService.getAllClientes();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable("id") String clientId) {
        return this.clientService.getClient(clientId);
    }

    @PostMapping()
    public void addClient(@RequestBody Client client) {
        this.clientService.addClient(client);
    }

    @PutMapping("{id}")
    public void updateClient(@PathVariable("id") String clientId, @RequestBody Client client) {
        this.clientService.getClient(clientId);
        this.clientService.addClient(client);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String clientId) {
        this.clientService.deleteClient(clientId);
    }
}
