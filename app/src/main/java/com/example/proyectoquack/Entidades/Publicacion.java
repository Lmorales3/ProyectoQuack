package com.example.proyectoquack.Entidades;

public class Publicacion {
    private String usuario;
    private String id;
    private String nombre_comida;
    private float valoracion;
    private String contenido;
    private int likes;
    private int dislikes;
    private String fecha;
    private String hora;

    public Publicacion(String id, String usuario, String nombre_comida, float valoracion,
                       String contenido, int likes, int dislikes, String fecha, String hora ){
        this.id = id;
        this.usuario = usuario;
        this.nombre_comida = nombre_comida;
        this.valoracion = valoracion;
        this.contenido = contenido;
        this.likes = likes;
        this.dislikes = dislikes;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getID(){ return id; }
    public String getUser(){ return usuario; }
    public String getNombre_comida(){ return nombre_comida; }
    public float getValoracion(){ return valoracion; }
    public String getContenido(){ return contenido; }
    public int getLikes(){ return likes; }
    public int getDislikes(){ return dislikes; }
    public String getFecha(){ return fecha; }
    public String getHora(){ return hora; }

    public void setUsuario(String usuario){ this.usuario = usuario; }
    public void setNombre_comida(String comida){ this.contenido = comida; }
    public void setValoracion(float val){ this.valoracion = val; }
    public void setContenido(String contenido){ this.contenido = contenido;}
    public void setLikes(boolean like){
        if(like) this.likes += 1;
        else this.dislikes += 1;
    }
    public void setFecha(String f){ this.fecha = f; }
    public void  setHora(String h){ this.hora = h; }

}
