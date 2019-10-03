package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;

public class PerfilUsuarioActivity extends AppCompatActivity {

    private Usuario usuario;
    private ImageView foto;

    private TextView username;
    private TextView nombre;
    private TextView rut;
    private TextView sexo;
    private TextView correo;
    private TextView telefono;
    private TextView preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        usuario= (Usuario)getIntent().getSerializableExtra("usuario_entidad");

        username = (TextView)findViewById(R.id.PerfilPasajeroActivity_username);
        nombre = (TextView)findViewById(R.id.PerfilPasajeroActivity_nombre);
        rut = (TextView)findViewById(R.id.PerfilPasajeroActivity_rut);
        sexo = (TextView)findViewById(R.id.PerfilPasajeroActivity_sexo);
        correo = (TextView)findViewById(R.id.PerfilPasajeroActivity_correo);
        telefono = (TextView)findViewById(R.id.PerfilPasajeroActivity_telefono);
        preferencias = (TextView)findViewById(R.id.PerfilPasajeroActivity_preferencias);

        username = (TextView)findViewById(R.id.PerfilPasajeroActivity_username);
        nombre = (TextView)findViewById(R.id.PerfilPasajeroActivity_nombre);
        rut = (TextView)findViewById(R.id.PerfilPasajeroActivity_rut);
        sexo = (TextView)findViewById(R.id.PerfilPasajeroActivity_sexo);
        correo = (TextView)findViewById(R.id.PerfilPasajeroActivity_correo);
        telefono = (TextView)findViewById(R.id.PerfilPasajeroActivity_telefono);
        preferencias = (TextView)findViewById(R.id.PerfilPasajeroActivity_preferencias);

        //username.setText("Username: " + usuario.getUsername());
        //nombre.setText("Nombre: " + usuario.getNombre());
        //rut.setText("Matricula: " + usuario.getRut());
        //sexo.setText("Sexo: " + usuario.getSexo());
        //correo.setText("Correo: " + usuario.getCorreo());
        //telefono.setText("Teléfono: " + usuario.getTelefono());
        //if(usuario.getPreferencias() != null) preferencias.setText("Preferencias: " + usuario.getPreferencias());

    }


    public void modificarPerfilPasajero(View view){
        Intent ModificarPerfilActivity = new Intent(this, ModificarPerfilActivity.class);
        ModificarPerfilActivity.putExtra("usuario_entidad", usuario);
        startActivity(ModificarPerfilActivity);
    }
/*
    public void modificarContrPasajero(View view) {
        Intent ModificarPerfilPasajeroActivity = new Intent(this, ModificarPerfilPasajeroActivity.class);
        ModificarPerfilPasajeroActivity.putExtra("usuario_entidad", usuario);
        startActivity(ModificarPerfilPasajeroActivity);
    }*/
}
