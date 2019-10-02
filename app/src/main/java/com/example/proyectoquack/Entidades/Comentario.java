package com.example.proyectoquack.Entidades;

public class Comentario {
    private String id;
    private String user;
    private String publicacion;
    private String comentario;
    private float valoracion;
    private String fecha;
    private String hora;

    public Comentario(String id, String user, String publicacion, String comentario,
                      float valoracion, String fecha, String hora){
        this.id = id;
        this.user = user;
        this.publicacion = publicacion;
        this.comentario = comentario;
        this.valoracion = valoracion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getID(){ return id; }
    public String getUser(){ return user; }
    public String getPublicacion(){ return publicacion; }
    public String getComentario(){ return  comentario; }
    public float getValoracion(){ return  valoracion; }
    public String getFecha(){ return  fecha; }
    public String getHora(){ return  hora; }

    public void setUser(String user){ this.user = user; }
    public void setPublicacion(String publicacion){ this.publicacion = publicacion; }
    public void setComentario(String c){ this.comentario = c; }
    public void setValoracion(float v){ this.valoracion = v; }
    public void setFecha(String f){ this.fecha = f; }
    public void setHora(String hora){ this.hora = hora; }

}
