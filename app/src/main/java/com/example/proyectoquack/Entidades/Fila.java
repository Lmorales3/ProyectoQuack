package com.example.proyectoquack.Entidades;

public class Fila {
    private String filaId;
    private Usuario user;
    private String fecha_hora;
    private float puntaje;
    private boolean es_junaeb;
    private boolean es_normal;

    public Fila(String filaId, Usuario user, String fecha_hora, float puntaje,
                boolean es_junaeb, boolean es_normal){
        this.filaId = filaId;
        this.user = user;
        this.fecha_hora = fecha_hora;
        this.puntaje = puntaje;
        this.es_junaeb = es_junaeb;
        this.es_normal = es_normal;
    }

    public Fila(){
        this.filaId = "0";
        this.user = new Usuario();
        this.fecha_hora = "0";
        this.puntaje = (float) 0.0;
        this.es_junaeb = false;
        this.es_normal = false;
    }

    public String getFilaId(){return filaId;}
    public Usuario getUser(){ return user; }
    public String getFecha_hora(){ return fecha_hora; }
    public float getPuntaje(){ return  puntaje; }
    public boolean es_junaeb(){ return  es_junaeb; }
    public boolean es_normal(){ return  es_normal; }

    public void setUser(Usuario user){ this.user = user; }
    public void setFecha_hora(String f){ this.fecha_hora = f; }
    public void setPuntaje(float p){ this.puntaje = p; }
    public void setEs_junaeb(boolean b){ this.es_junaeb = b; }
    public void setEs_normal(boolean b){ this.es_normal = b; }

    // public void getPromerdio ???
}
