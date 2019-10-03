package com.example.proyectoquack.Entidades;

public class Comentario {
    private String comentId;
    private String user;
    private String publicacion;
    private String comentario;
    private float valoracion;
    private String fecha_hora;

    public Comentario(String comentId, String user, String publicacion, String comentario,
                      float valoracion, String fecha_hora){
        this.comentId = comentId;
        this.user = user;
        this.publicacion = publicacion;
        this.comentario = comentario;
        this.valoracion = valoracion;
        this.fecha_hora = fecha_hora;
    }

    public String getID(){ return comentId; }
    public String getUser(){ return user; }
    public String getPublicacion(){ return publicacion; }
    public String getComentario(){ return  comentario; }
    public float getValoracion(){ return  valoracion; }
    public String getFecha_hora(){ return fecha_hora; }

    public void setUser(String user){ this.user = user; }
    public void setPublicacion(String publicacion){ this.publicacion = publicacion; }
    public void setComentario(String c){ this.comentario = c; }
    public void setValoracion(float v){ this.valoracion = v; }
    public void setFecha_hora(String f){ this.fecha_hora = f; }

}
