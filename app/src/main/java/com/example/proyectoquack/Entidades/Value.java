package com.example.proyectoquack.Entidades;

public class Value {
    private float value;

    public Value(float value) {
        this.value = value;
    }

    public Value() {
        this.value = (float) 0.0;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
