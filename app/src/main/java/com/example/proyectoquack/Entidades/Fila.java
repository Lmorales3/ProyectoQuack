package com.example.proyectoquack.Entidades;

public class Fila {
    private String id;
    private String user;
    private String fecha;
    private String hora;
    private float puntaje;
    private boolean es_junaeb;
    private boolean es_normal;

    public Fila(String id, String user, String fecha, String hora, float puntaje,
                boolean es_junaeb, boolean es_normal){
        this.id = id;
        this.user = user;
        this.fecha = fecha;
        this.hora = hora;
        this.puntaje = puntaje;
        this.es_junaeb = es_junaeb;
        this.es_normal = es_normal;
    }

    public String getId(){return id;}
    public String getUser(){ return user; }
    public String getFecha(){ return fecha; }
    public String getHora(){ return  hora; }
    public float getPuntaje(){ return  puntaje; }
    public boolean es_junaeb(){ return  es_junaeb; }
    public boolean es_normal(){ return  es_normal; }

    public void setUser(String user){ this.user = user; }
    public void setFecha(String f){ this.fecha = f; }
    public void setHora(String h){ this.hora = h; }
    public void setPuntaje(float p){ this.puntaje = p; }
    public void setEs_junaeb(boolean b){ this.es_junaeb = b; }
    public void setEs_normal(boolean b){ this.es_normal = b; }

    // public void getPromerdio ???
}
