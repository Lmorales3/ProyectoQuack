package com.example.proyectoquack.DB;

import com.example.proyectoquack.Entidades.Comentario;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Fila;
import com.example.proyectoquack.Entidades.Publicacion;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.Entidades.Value;

import java.math.BigInteger;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonApi {

    // Metodos de Comentario

    @GET("comentario/obtener/{id}")
    Call<Comentario> obtenerComentario(@Path("id") BigInteger id);

    @POST("comentario/crear")
    Call<Comentario> crearComentario(@Body Comentario comentario);

    // Metodos de Comida

    @POST("comida/crear")
    Call<Comida> crearComida(@Body Comida comida);

    @GET("comida/obtener/{id}")
    Call<Comida> obtenerComida(@Path("id") BigInteger id);

    @GET("comida/obtener/comida_del_dia")
    Call<List <Comida>> comidaDelDia();

    @PATCH("comida/set_comida_dia/{comida1}/{comida2}/{comida3}/{comida4}")
    Call<List <Comida>> setComidaDia(
            @Path("comida1") String comida1,
            @Path("comida1") String comida2,
            @Path("comida1") String comida3,
            @Path("comida1") String comida4
    );

    @GET("comida/mejor_comida/{n}")
    Call<List <Comida>> mejorComida(@Path("n") BigInteger n);

    @GET("comida/todos")
    Call<List <Comida>> comidaTodos();

    // Metodos de Fila

    @POST("fila/crear")
    Call<Fila> crearFila(@Body Fila fila);

    @GET("fila/obtener/{id}")
    Call<Fila> obtenerFila(@Path("id") BigInteger id);

    @GET("fila/mean_value/{fecha_hora}")
    Call<Value> mean_value(@Path("fecha_hora") String fecha_hora);

    //  Metodos de Publicacion

    @POST("publicacion/crear")
    Call<Publicacion> crearPublicacion(@Body Publicacion publicacion);

    @GET("publicacion/obtener/{id}")
    Call<Publicacion> obtenerPublicacion(@Path("id") BigInteger id);

    @GET("publicacion/AddLike/{id}/{like}")
    Call<Publicacion> Like(
            @Path("id") BigInteger id,
            @Path("like") boolean like
    );

    // Metodos de Usuario

    @POST("usuario/crear")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @GET("usuario/obtener/{username}")
    Call<Usuario> obtenerUsuario(@Path("username") String username);

    @GET("usuario/best_launch/{username}")
    Call<Comida> best_launch(@Path("username") String username);
}
