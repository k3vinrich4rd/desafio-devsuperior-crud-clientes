package com.devsuperior.desafio_crud_clientes.services;

import com.devsuperior.desafio_crud_clientes.dto.ClientDto;
import com.devsuperior.desafio_crud_clientes.entities.Client;
import com.devsuperior.desafio_crud_clientes.repositories.ClientRepository;
import com.devsuperior.desafio_crud_clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ClientDto insertClient(ClientDto clientDto) {
        Client client = new Client();
        copyDtoToEntity(clientDto, client);
        client = clientRepository.save(client);
        return new ClientDto(client);
    }

    private void copyDtoToEntity(ClientDto clientDto, Client entity) {
        entity.setName(clientDto.getName());
        entity.setCpf(clientDto.getCpf());
        entity.setIncome(clientDto.getIncome());
        entity.setBirthDate(clientDto.getBirthDate());
        entity.setChildren(clientDto.getChildren());
    }

    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientDto::new);
    }

    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id + ", Type: " + Client.class.getName()));
        return new ClientDto(client);
    }
}
