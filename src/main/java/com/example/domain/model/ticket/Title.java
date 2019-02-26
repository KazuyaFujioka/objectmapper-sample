package com.example.domain.model.ticket;

import javax.validation.constraints.Size;

/**
 * タイトル
 */
class Title {

    @Size(max = 15, message = "{max}文字以内にしてください")
    String value;

    Title(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private Title() {
    }
}