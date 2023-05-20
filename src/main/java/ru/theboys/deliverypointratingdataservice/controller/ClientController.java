package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.Client;
import ru.theboys.deliverypointratingdataservice.service.ClientService;
import java.util.List;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return this.clientService.getAllClients();
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
        Client clientFromDB = this.clientService.getClient(clientId);
        BeanUtils.copyProperties(client, clientFromDB, "id");
        this.clientService.addClient(clientFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String clientId) {
        this.clientService.deleteClient(clientId);
    }
}
