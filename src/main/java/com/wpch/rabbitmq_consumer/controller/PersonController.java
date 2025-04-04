package com.wpch.rabbitmq_consumer.controller;

import com.wpch.rabbitmq_consumer.dto.PersonDTO;
import com.wpch.rabbitmq_consumer.dto.PersonRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/persons")
@Tag(name = "Pessoas", description = "Operações relacionadas a pessoas")
public class PersonController {

    @GetMapping("/{id}")
    @Operation(summary = "Obter pessoa por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Pessoa encontrada"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public PersonDTO getPersonById(@PathVariable UUID id) {
        // Lógica para obter a pessoa do banco de dados
        return null;
    }

    @PostMapping
    @Operation(summary = "Criar nova pessoa", responses = {
            @ApiResponse(responseCode = "201", description = "Pessoa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public PersonDTO createPerson(@RequestBody PersonRequestDTO person) {
        // Lógica para salvar a pessoa no banco de dados
        return null;
    }

    // Outros métodos de controle...
    /*
    * TODO: listar sem paginação, remover, listar com paginação
    * */
}
