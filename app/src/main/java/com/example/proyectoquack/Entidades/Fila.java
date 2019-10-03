package com.example.proyectoquack.Entidades;

public class Fila {
    private String filaId;
    private String user;
    private String fecha_hora;
    private float puntaje;
    private boolean es_junaeb;
    private boolean es_normal;

    public Fila(String filaId, String user, String fecha_hora, float puntaje,
                boolean es_junaeb, boolean es_normal){
        this.filaId = filaId;
        this.user = user;
        this.fecha_hora = fecha_hora;
        this.puntaje = puntaje;
        this.es_junaeb = es_junaeb;
        this.es_normal = es_normal;
    }

    public String getFilaId(){return filaId;}
    public String getUser(){ return user; }
    public String getFecha_hora(){ return fecha_hora; }
    public float getPuntaje(){ return  puntaje; }
    public boolean es_junaeb(){ return  es_junaeb; }
    public boolean es_normal(){ return  es_normal; }

    public void setUser(String user){ this.user = user; }
    public void setFecha_hora(String f){ this.fecha_hora = f; }
    public void setPuntaje(float p){ this.puntaje = p; }
    public void setEs_junaeb(boolean b){ this.es_junaeb = b; }
    public void setEs_normal(boolean b){ this.es_normal = b; }

    // public void getPromerdio ???
}
