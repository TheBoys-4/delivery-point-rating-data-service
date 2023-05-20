package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Client;
import ru.theboys.deliverypointratingdataservice.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private static final String NO_CLIENT_FOUND = "No client with id %s found";
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClientes() {
        return this.clientRepository.findAll();
    }

    public Client getClient(String clientId) {
        return this.clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException(String.format(NO_CLIENT_FOUND, clientId)));
    }

    public void addClient(Client client) {
        this.clientRepository.save(client);
    }

    public void deleteClient(String clientId) {
        this.getClient(clientId);
        this.clientRepository.deleteById(clientId);
    }
}
