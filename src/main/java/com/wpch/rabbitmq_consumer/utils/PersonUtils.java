package com.wpch.rabbitmq_consumer.utils;

import com.wpch.rabbitmq_consumer.dto.PersonDTO;

public class PersonUtils {

    public static void errorMsg(Exception e) {
        System.err.println("❌ Erro ao processar mensagem: " + e.getMessage());
    }

    public static void successMsg(PersonDTO personDTO) {
        System.out.println("✅ Mensagem Recebida -> ID: " + personDTO.getId()
                + ", Nome: " + personDTO.getName());
    }
}