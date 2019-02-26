package com.example;

import com.example.domain.model.ticket.Ticket;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.MutablePropertyValues;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class TicketDeserializer extends JsonDeserializer<Ticket> {

    @Override
    public Ticket deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String rootPath = "ticket";
        JsonNode node = parser.getCodec().readTree(parser);

        MutablePropertyValues propertyValues = new MutablePropertyValues();

        propertyValues.add(TicketMapping.タイトル.modelPath(), node.path(rootPath).get(TicketMapping.タイトル.jsonPath()).asText());

        if(node.path(rootPath).get(TicketMapping.価格.jsonPath()).isNumber())
            propertyValues.add(TicketMapping.価格.modelPath(), node.path(rootPath).get(TicketMapping.価格.jsonPath()).decimalValue());

        Ticket ticket = Ticket.prototype();
        DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(ticket);
        directFieldAccessor.setPropertyValues(propertyValues);

        return ticket;
    }
}