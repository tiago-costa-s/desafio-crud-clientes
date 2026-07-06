package com.tcdev.desafio_crud_clientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
        this.erros = erros;
    }

    public List<FieldMessage> getErros() {return erros;}

    public void addError(String fieldName, String message) {erros.add(new FieldMessage(fieldName, message));}
}