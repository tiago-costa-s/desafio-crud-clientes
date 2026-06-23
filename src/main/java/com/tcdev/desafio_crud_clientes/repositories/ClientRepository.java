package com.tcdev.desafio_crud_clientes.repositories;

import com.tcdev.desafio_crud_clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}