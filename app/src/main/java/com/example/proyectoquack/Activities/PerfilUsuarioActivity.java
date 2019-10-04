package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoquack.DB.ModelApi;
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
    private ModelApi modelApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        usuario= (Usuario)getIntent().getSerializableExtra("usuario_entidad");
        modelApi= new ModelApi();

        username = (TextView)findViewById(R.id.PerfilPasajeroActivity_username);
        nombre = (TextView)findViewById(R.id.PerfilPasajeroActivity_nombre);
        rut = (TextView)findViewById(R.id.PerfilPasajeroActivity_rut);
        sexo = (TextView)findViewById(R.id.PerfilPasajeroActivity_sexo);
        correo = (TextView)findViewById(R.id.PerfilPasajeroActivity_correo);
        telefono = (TextView)findViewById(R.id.PerfilPasajeroActivity_telefono);
        preferencias = (TextView)findViewById(R.id.PerfilPasajeroActivity_preferencias);


        Usuario usuario1 = modelApi.obtenerUsuario(usuario.getNombre_usuario());
    }


    public void modificarPerfil(View view){
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
