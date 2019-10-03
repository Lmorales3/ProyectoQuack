package com.example.proyectoquack.Entidades;

public class Comida {
    private String nombre_comida;
    private float puntaje_promedio;
    private boolean comida_del_dia;

    public Comida(String nombre_comida, float puntaje_promedio, boolean comida_del_dia){
        this.comida_del_dia = comida_del_dia;
        this.puntaje_promedio = puntaje_promedio;
        this.nombre_comida = nombre_comida;
    }

    public String getNombre_comida(){ return nombre_comida; }
    public float getPuntaje_promedio(){ return puntaje_promedio; }
    public boolean isComida_del_dia(){ return  comida_del_dia; }

    public void setNombre_comida(String n){ this.nombre_comida = n; }
    public void setPuntaje_promedio(float p){ this.puntaje_promedio = p; }
    public void setComida_del_dia(boolean b){ this.comida_del_dia = b; }

}