package com.example.domain.model.ticket;

import com.example.domain.type.Amount;

import javax.validation.Valid;

/**
 * チケット
 */
public class Ticket {

    @Valid
    Title title;

    @Valid
    Price price;

    public Ticket(Title title, Price price) {
        this.title = title;
        this.price = price;
    }

    public static Ticket prototype() {
        return new Ticket(new Title(""), new Price(new Amount(null)));
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "title=" + title +
                ", price=" + price +
                '}';
    }

    private Ticket() {
    }
}