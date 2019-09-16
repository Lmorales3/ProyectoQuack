package com.example.proyectoquack.Entidades;

import java.io.Serializable;

public class Conductor implements Serializable {
    private String username;
    private String nombre;
    private String password;
    private String correo;
    private String telefono;
    private String rut;
    private String sexo;
    public Conductor(String username, String nombre, String password, String correo, String telefono, String rut, String sexo){
        this.username=username;
        this.nombre=nombre;
        this.password=password;
        this.correo=correo;
        this.telefono=telefono;
        this.rut=rut;
        this.sexo=sexo;
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

    public String getTelefono() {
        return telefono;
    }

    public String getRut() {
        return rut;
    }

    public String getSexo() {
        return sexo;
    }

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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
