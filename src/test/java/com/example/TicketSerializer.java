package com.example;

import com.example.domain.model.ticket.Ticket;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.DirectFieldAccessor;

import java.io.IOException;

public class TicketSerializer extends JsonSerializer<Ticket> {

    @Override
    public void serialize(Ticket ticket,
                          JsonGenerator generator,
                          SerializerProvider serializers) throws IOException {
        DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(ticket);

        generator.writeStartObject();
        generator.writeObjectField(TicketMapping.タイトル.jsonPath(), directFieldAccessor.getPropertyValue(TicketMapping.タイトル.modelPath()));
        generator.writeObjectField(TicketMapping.価格.jsonPath(), directFieldAccessor.getPropertyValue(TicketMapping.価格.modelPath()));
        generator.writeEndObject();
    }
}