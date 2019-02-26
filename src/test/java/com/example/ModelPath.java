package com.example;

class ModelPath {

    String value;

    ModelPath(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private ModelPath() {
    }
}