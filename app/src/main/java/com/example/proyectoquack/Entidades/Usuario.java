package com.example.proyectoquack.Entidades;

import java.io.Serializable;
import java.util.*;

public class Usuario implements Serializable {
    private String username;
    private String nombre;
    private String password;
    private String correo;
    private String fecha_nacimiento;
    private String carrera;
    private Vector almuerzos_preferidos;
    private float quack_puntos;
    public Usuario (String username, String nombre, String password, String correo, Vector almuerzos,
                    String fecha_nacimiento, String carrera, float quack_puntos){
        this.username=username;
        this.nombre=nombre;
        this.password=password;
        this.correo=correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carrera = carrera;
        this.quack_puntos = quack_puntos;
        this.almuerzos_preferidos = (Vector)almuerzos.clone();
    }

    public String getUsername(){
        return username;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPassword() {
        return password;
    }
    public String getCorreo() {
        return correo;
    }
    public Vector getAlmuerzos_preferidos(){ return almuerzos_preferidos; }
    public String getFecha_nacimiento(){ return  fecha_nacimiento; }
    public String getCarrera(){ return carrera; }
    public float getQuack_puntos(){ return  quack_puntos; }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setFecha_nacimiento(String fecha){ this.fecha_nacimiento = fecha; }
    public void setCarrera(String c){ this.carrera = c; }
    public void setAlmuerzos_preferidos(Vector a){ this.almuerzos_preferidos = (Vector)a.clone(); }
    public void setQuack_puntos(float puntos){ this.quack_puntos = puntos; }

}
