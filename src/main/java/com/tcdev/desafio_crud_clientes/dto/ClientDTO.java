package com.tcdev.desafio_crud_clientes.dto;

import com.tcdev.desafio_crud_clientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {
        private Long id;
        @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres." )
        @NotBlank(message = "Campo requerido.")
        private String name;
        private String cpf;
        @PastOrPresent(message = "Data de nascimento: não pode ser data futura")
        private LocalDate birthDate;
        private Integer children;
        private Double income;

        public ClientDTO(Client entity) {
            id = entity.getId();
            name = entity.getName();
            cpf = entity.getCpf();
            birthDate = entity.getBirthDate();
            children = entity.getChildren();
            income = entity.getIncome();
        }

        public ClientDTO(Long id, String name, String cpf, LocalDate birthDate, Integer children, Double income) {
            this.id = id;
            this.name = name;
            this.cpf = cpf;
            this.birthDate = birthDate;
            this.children = children;
            this.income = income;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCpf() {
            return cpf;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public Integer getChildren() {
            return children;
        }

        public Double getIncome() {
            return income;
        }

}
