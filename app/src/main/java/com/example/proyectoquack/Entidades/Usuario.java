package com.example.proyectoquack.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre_usuario;
    private String nombre_real;
    private String password;
    private String correo;
    private String fecha_nacimiento;
    private String carrera;
    private float quack_puntos;

    public Usuario (String nombre_usuario, String nombre_real, String password, String correo, String fecha_nacimiento, String carrera, float quack_puntos){
        this.nombre_usuario = nombre_usuario;
        this.nombre_real = nombre_real;
        this.password=password;
        this.correo=correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carrera = carrera;
        this.quack_puntos=quack_puntos;
    }

    public String getNombre_usuario(){
        return nombre_usuario;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public String getPassword() {
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public float getQuack_puntos() {
        return quack_puntos;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setQuack_puntos(float quack_puntos) {
        this.quack_puntos = quack_puntos;
    }
}
