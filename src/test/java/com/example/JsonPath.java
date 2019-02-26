package com.example;

class JsonPath {

    String value;

    JsonPath(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private JsonPath() {
    }
}