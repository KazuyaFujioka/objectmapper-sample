package com.example.domain.model.ticket;

import com.example.domain.type.Amount;

import javax.validation.Valid;

/**
 * チケット価格
 */
class Price {

    @Valid
    Amount amount;

    Price(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return amount.toString();
    }

    private Price() {
    }
}