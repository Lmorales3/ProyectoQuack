package com.example.proyectoquack.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText apellidoPaterno;
    private EditText carrera;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private EditText correo;
    private EditText fecha_nacimiento;
    //private EditText rut2;
    //private RadioButton hombre;
    //private RadioButton mujer;

    private ModelApi modelApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        modelApi = new ModelApi();

        nombre = (EditText)findViewById(R.id.RegistroActivity_Nombre);
        apellidoPaterno = (EditText)findViewById(R.id.RegistroActivity_ApellidoPaterno);
        carrera = (EditText)findViewById(R.id.carrera);
        username = (EditText)findViewById(R.id.RegistroActivity_Usuario);
        password1 = (EditText)findViewById(R.id.RegistroActivity_Contraseña1);
        password2 = (EditText)findViewById(R.id.RegistroActivity_Contrasena2);
        correo = (EditText)findViewById(R.id.RegistroActivity_Email);

        fecha_nacimiento = (EditText)findViewById(R.id.fecha_nacimiento);
       // rut2 = (EditText)findViewById(R.id.RegistroActivity_Rut2);
        //conductor = (RadioButton)findViewById(R.id.RegistroActivity_Conductor);
       // pasajero = (RadioButton)findViewById(R.id.RegistroActivity_Pasajero);
       // hombre = (RadioButton)findViewById(R.id.RegistroActivity_SexoM);
        //mujer = (RadioButton)findViewById(R.id.RegistroActivity_SexoF);

    }

    public void Registrar(View view){
        String str_nombre = nombre.getText().toString();
        String str_apellidoPaterno = apellidoPaterno.getText().toString();
        String str_carrera = carrera.getText().toString();
        String str_username = username.getText().toString();
        String str_password1 = password1.getText().toString();
        String str_password2 = password2.getText().toString();
        String str_correo = correo.getText().toString();
        String str_fecha_nacimiento = fecha_nacimiento.getText().toString();


        if(!str_nombre.isEmpty() && !str_apellidoPaterno.isEmpty()
                && !str_carrera.isEmpty() && !str_username.isEmpty()
                && !str_password1.isEmpty() && !str_password2.isEmpty()
                && !str_correo.isEmpty() && !str_fecha_nacimiento.isEmpty()){
                if(str_password1.compareTo(str_password2)==0){

                    String nombre = str_nombre + str_apellidoPaterno;
                    Usuario usuario = new Usuario(str_username, nombre, str_password1, str_correo, str_fecha_nacimiento, str_carrera,
                            (float)0.0, new ArrayList<Comida>());

                    Usuario usuario1 = modelApi.crearUsuario(usuario);

                }
                else Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_LONG).show();

        }
        else Toast.makeText(this, "Hay campos sin rellenar", Toast.LENGTH_LONG).show();

    }


}
