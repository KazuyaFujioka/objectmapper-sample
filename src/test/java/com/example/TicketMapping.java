package com.example;

enum TicketMapping {

    タイトル(new ModelPath("title.value"), new JsonPath("title")),
    価格(new ModelPath("price.amount.value"), new JsonPath("price"));

    private ModelPath model;
    private JsonPath json;

    TicketMapping(ModelPath model, JsonPath json) {
        this.model = model;
        this.json = json;
    }

    String modelPath() {
        return this.model.toString();
    }

    String jsonPath() {
        return this.json.toString();
    }
}