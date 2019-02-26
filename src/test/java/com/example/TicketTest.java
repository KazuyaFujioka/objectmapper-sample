package com.example;

import com.example.domain.model.ticket.Ticket;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class TicketTest {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NON_PRIVATE);
        objectMapper.setVisibility(PropertyAccessor.GETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER,JsonAutoDetect.Visibility.NONE);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Ticket.class, new TicketDeserializer());
        module.addSerializer(Ticket.class, new TicketSerializer());
        objectMapper.registerModule(module);

        String json = "{\n" +
                "  \"id\": 456,\n" +
                "  \"ticket\": {\n" +
                "    \"price\": 1500, \n" +
                "    \"title\": \"ticket title\", \n" +
                "    \"description\": \"description\"\n" +
                "  }\n" +
                "}";

        // json to model(ticket)
        Ticket ticket = objectMapper.readValue(json, Ticket.class);
        System.out.println("ticket=" + ticket);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Ticket>> errors = validator.validate(ticket);
        System.out.println("errors=" + errors);

        // ticket to json using serializer
        json = objectMapper.writeValueAsString(ticket);
        System.out.println("json=" + json);
    }
}