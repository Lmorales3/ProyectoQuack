package com.example.proyectoquack.DB;

import com.example.proyectoquack.Entidades.Comentario;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Fila;
import com.example.proyectoquack.Entidades.Publicacion;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.Entidades.Value;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelApi {

    private JsonApi jsonApi;

    public ModelApi() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://proyecto-quack.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonApi = retrofit.create(JsonApi.class);
    }

    public Comentario obtenerComentario(BigInteger id){
        Call<Comentario> call = jsonApi.obtenerComentario(id);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Comentario();
        }
    }

    public Comentario crearComentario(Comentario comentario){
        Call<Comentario> call = jsonApi.crearComentario(comentario);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Comentario();
        }
    }

    // Metodos de Comida

    public Comida crearComida(Comida comida){
        Call<Comida> call = jsonApi.crearComida(comida);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Comida();
        }
    }

    public Comida obtenerComida(BigInteger id){
        Call<Comida> call = jsonApi.obtenerComida(id);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Comida();
        }
    }

    public List <Comida> comidaDelDia(){
        Call<List<Comida>> call = jsonApi.comidaDelDia();
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new ArrayList<Comida>();
        }
    }

    public List <Comida> setComidaDia(String comida1, String comida2, String comida3,
                                      String comida4){
        Call<List<Comida>> call = jsonApi.setComidaDia(comida1,comida2,comida3,comida4);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new ArrayList<Comida>();
        }
    }

    public List <Comida> mejorComida(BigInteger n){
        Call<List<Comida>> call = jsonApi.mejorComida(n);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new ArrayList<Comida>();
        }
    }

    public List <Comida> comidaTodos(){
        Call<List<Comida>> call = jsonApi.comidaTodos();
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new ArrayList<Comida>();
        }
    };

    // Metodos de Fila

    public Fila crearFila(Fila fila){
        Call<Fila> call = jsonApi.crearFila(fila);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Fila();
        }
    };

    public Fila obtenerFila(BigInteger id){
        Call<Fila> call = jsonApi.obtenerFila(id);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Fila();
        }
    };

    public Value mean_value(String fecha_hora){
        Call<Value> call = jsonApi.mean_value(fecha_hora);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Value();
        }
    };

    //  Metodos de Publicacion

    public Publicacion crearPublicacion(Publicacion publicacion){
        Call<Publicacion> call = jsonApi.crearPublicacion(publicacion);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Publicacion();
        }
    };

    public Publicacion obtenerPublicacion(BigInteger id){
        Call<Publicacion> call = jsonApi.obtenerPublicacion(id);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Publicacion();
        }
    };

    public Publicacion Like(BigInteger id, boolean like){
        Call<Publicacion> call = jsonApi.Like(id, like);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Publicacion();
        }
    };

    // Metodos de Usuario

    public Usuario crearUsuario(Usuario usuario){
        Call<Usuario> call = jsonApi.crearUsuario(usuario);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Usuario();
        }
    };

    public Usuario obtenerUsuario(String username){
        Call<Usuario> call = jsonApi.obtenerUsuario(username);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Usuario();
        }
    };

    public Comida best_launch(String username){
        Call<Comida> call = jsonApi.best_launch(username);
        try {
            return call.execute().body();
        } catch (IOException e) {
            return new Comida();
        }
    };


}
