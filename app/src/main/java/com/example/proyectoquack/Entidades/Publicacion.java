package com.example.proyectoquack.Entidades;

public class Publicacion {
    private Usuario user;
    private String pubId;
    private String nombre_comida;
    private float valoracion;
    private String contenido;
    private int likes;
    private int dislikes;
    private String fecha_hora;

    public Publicacion(String pubId, Usuario user, String nombre_comida, float valoracion,
                       String contenido, int likes, int dislikes, String fecha_hora ){
        this.pubId = pubId;
        this.user = user;
        this.nombre_comida = nombre_comida;
        this.valoracion = valoracion;
        this.contenido = contenido;
        this.likes = likes;
        this.dislikes = dislikes;
        this.fecha_hora = fecha_hora;
    }

    public String getID(){ return pubId; }
    public Usuario getUser(){ return user; }
    public String getNombre_comida(){ return nombre_comida; }
    public float getValoracion(){ return valoracion; }
    public String getContenido(){ return contenido; }
    public int getLikes(){ return likes; }
    public int getDislikes(){ return dislikes; }
    public String getFecha_hora(){ return fecha_hora; }

    public void setUser(Usuario user){ this.user = user; }
    public void setNombre_comida(String comida){ this.contenido = comida; }
    public void setValoracion(float val){ this.valoracion = val; }
    public void setContenido(String contenido){ this.contenido = contenido;}
    public void setLikes(boolean like){
        if(like) this.likes += 1;
        else this.dislikes += 1;
    }
    public void setFecha_hora(String f){ this.fecha_hora = f; }

}
