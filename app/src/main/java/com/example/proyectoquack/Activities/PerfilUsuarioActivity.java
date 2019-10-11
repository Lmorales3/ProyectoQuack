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
    private TextView correo;
    private TextView telefono;
    private ModelApi modelApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        usuario= (Usuario)getIntent().getSerializableExtra("usuario_entidad");
        modelApi= new ModelApi();

        username = (TextView)findViewById(R.id.PerfilPasajeroActivity_username);
        nombre = (TextView)findViewById(R.id.PerfilPasajeroActivity_nombre);
        correo = (TextView)findViewById(R.id.PerfilPasajeroActivity_correo);
        telefono = (TextView)findViewById(R.id.PerfilPasajeroActivity_telefono);




        Usuario usuario1 = modelApi.obtenerUsuario(usuario.getNombre_usuario());


        nombre.setText(usuario.getNombre_usuario());
        nombre.setText(usuario.getNombre_real());
        telefono.setText(usuario.getFecha_nacimiento());



    }


    public void modificarPerfil(View view){
        Intent ModificarPerfilActivity = new Intent(this, ModificarPerfilActivity.class);
        ModificarPerfilActivity.putExtra("usuario_entidad", usuario);
        startActivity(ModificarPerfilActivity);
    }

}
