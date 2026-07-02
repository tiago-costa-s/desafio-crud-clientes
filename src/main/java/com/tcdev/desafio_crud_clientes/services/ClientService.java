package com.tcdev.desafio_crud_clientes.services;

import com.tcdev.desafio_crud_clientes.dto.ClientDTO;
import com.tcdev.desafio_crud_clientes.entities.Client;
import com.tcdev.desafio_crud_clientes.repositories.ClientRepository;
import com.tcdev.desafio_crud_clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> results = repository.findAll(pageable);
        return results.map((x)-> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado id: " + id));
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
}