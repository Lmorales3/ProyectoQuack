package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectoquack.DB.DBQueries;

import com.example.proyectoquack.DB.JsonApi;
import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.DB.ModelApiTest;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Publicacion;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private SharedPreferences sharedPreferences;
    private EditText username;
    private EditText password;
    private RadioButton conductor;
    private RadioButton pasajero;
    private ImageView logo;
    private boolean autoLogin=false;
    private ModelApi modelApi;
    private ModelApiTest modelApiTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        modelApi = new ModelApi();
        modelApiTest = new ModelApiTest();

        logo = (ImageView)findViewById(R.id.MainActivity_logo);
        username = (EditText)findViewById(R.id.MainActivity_username);
        password = (EditText)findViewById(R.id.MainActivity_password);
      /*  conductor = (RadioButton)findViewById(R.id.MainActivity_usuario_check);
        */

        //RecuperarDatos();
        if(autoLogin)AutoLogin();
    }

    public void Ingresar(View view) {
        Login(false);
    }

    private void AutoLogin(){
        Login(true);
    }

    private void Login(boolean comingback){
        //GuardarDatos();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();

        if (!str_username.isEmpty() && !str_password.isEmpty()) {

            //Caso especial para iniciar

            if(str_username.equals("u") && str_password.equals("p")){
                Intent UsuarioActivity = new Intent(this, UsuarioActivity.class);
                startActivity(UsuarioActivity);
                this.finish();
            }

            else if(str_username.equals("f") && str_password.equals("f")){
                Intent FilaActivity = new Intent(this, EstadoFilaActivity.class);
                startActivity(FilaActivity);
                this.finish();
            }

            else if(str_username.equals("u") && str_password.equals("u")){
                BigInteger a = new BigInteger("5629499534213120");
                Comida comida = modelApi.obtenerComida(a);
                String content = "";
                content += comida.getNombre_comida();

                Toast.makeText(this, content, Toast.LENGTH_LONG).show();

                Usuario usuario2 = new Usuario("usuario", "usuario apellido", "asd", "usuario@gmail.com", "01/01/2019", "Informatica", (float)0.0 , new ArrayList<Comida>());

                modelApi.crearUsuario(usuario2);
                Usuario usuario3 = modelApi.obtenerUsuario("usuario");

                String content2 = "";
                content2 += usuario3.getNombre_real();

                Toast.makeText(this, content2, Toast.LENGTH_LONG).show();
            }

            else if(str_username.equals("p") && str_password.equals("p")){
                BigInteger a = new BigInteger("5629499534213120");
                Comida comida = modelApi.obtenerComida(a);

                String content = "";
                content += comida.getNombre_comida();

                Toast.makeText(this, content, Toast.LENGTH_LONG).show();
/*
                Comida comida1 = new Comida("Mechada con pure", (float) 0.0, true);
                Comida comida2 = modelApi.crearComida(comida1);
                String content2 = "";
                content2 += comida2.getNombre_comida();

                Toast.makeText(this, content2, Toast.LENGTH_LONG).show();*/
            }

            else if(str_username.equals("a") && str_password.equals("a")){
                Usuario usuario2 = modelApi.obtenerUsuario("Juan");
                BigInteger a = new BigInteger("5629499534213120");
                Comida comida = modelApi.obtenerComida(a);

                Comida comida1 = modelApiTest.crearComida(comida);
                Usuario usuario = modelApiTest.crearUsuario(usuario2);

                Publicacion publicacion = new Publicacion("5", usuario, comida1, (float) 4.5, "Wena wena", 2, 2, "01/01/2019");

                Publicacion publicacion2 = modelApiTest.crearPublicacion(publicacion);

                String content = "";
                content += publicacion2.getContenido();
                content += "---" + publicacion2.getFecha_hora();

                Toast.makeText(this, content, Toast.LENGTH_LONG).show();
            }



            else if(str_username.equals("usuario")){
                Intent FilaActivity = new Intent(this, UsuarioActivity.class);
                Usuario usuario2 = new Usuario("usuario", "usuario apellido", "asd", "usuario@gmail.com", "01/01/2019", "Informática", (float)0.0 , new ArrayList<Comida>());
                FilaActivity.putExtra("usuario_entidad", usuario2);
                startActivity(FilaActivity);
                this.finish();
            }

            else{
                Usuario usuario = modelApi.obtenerUsuario(str_username);
                //&& usuario.getPassword().equals(str_password)
                if (!usuario.getNombre_usuario().equals("0")){
                    Intent UsuarioActivity = new Intent(this, UsuarioActivity.class);
                    UsuarioActivity.putExtra("usuario_entidad", usuario);
                    startActivity(UsuarioActivity);
                    this.finish();
                }
                else{
                    Toast.makeText(this, "Usuario y/o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                }
            }

        } else Toast.makeText(this, "Ingrese Usuario y/o Contraseña", Toast.LENGTH_LONG).show();
    }

    public void Registrar(View view){
        Intent RegistroActivity = new Intent(this, com.example.proyectoquack.Activities.RegistroActivity.class);
        startActivity(RegistroActivity);
    }

    private void RecuperarDatos(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        conductor.setChecked(sharedPreferences.getBoolean("Conductor", false));
        pasajero.setChecked(sharedPreferences.getBoolean("Pasajero", false));
        username.setText(sharedPreferences.getString("Username", ""));
        password.setText(sharedPreferences.getString("Password", ""));
        autoLogin=sharedPreferences.getBoolean("AutoLogin", false);

    }
/*
    private void GuardarDatos(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Conductor", conductor.isChecked());
        editor.putBoolean("Pasajero", pasajero.isChecked());
        editor.putString("Username", username.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.putBoolean("AutoLogin", true);
        editor.apply();
    }*/

    public List<Comida> comidaTodos(){
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://proyecto-quack.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);
        Call<List<Comida>> call = jsonApi.comidaTodos();
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<Comida>();
    }

}