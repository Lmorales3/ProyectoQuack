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
    private TextView Almuerzos_preferidos;
    private TextView carrera;
    private TextView Quack_puntos;
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
        carrera = (TextView)findViewById(R.id.carrera);
        Almuerzos_preferidos =(TextView)findViewById(R.id.almuerzos_preferidos);
        Quack_puntos=(TextView)findViewById(R.id.Quack_puntos);





        Usuario usuario1 = modelApi.obtenerUsuario(usuario.getNombre_usuario());

        username.setText("Username: " + usuario.getNombre_usuario());
        nombre.setText("Nombre: " + usuario.getNombre_real());

        //rut.setText("Matricula: " + usuario.getRut());
        //sexo.setText("Sexo: " + usuario.getSexo());
        correo.setText("Correo: " + usuario.getCorreo());
        Quack_puntos.setText("Quack puntos: " + usuario.getQuack_puntos());

        //telefono.setText("Teléfono: " + usuario.getTelefono());
        //if(usuario.getPreferencias() != null) preferencias.setText("Preferencias: " + usuario.getPreferencias());

    }


    public void modificarPerfil(View view){
        Intent ModificarPerfilActivity = new Intent(this, ModificarPerfilActivity.class);
        ModificarPerfilActivity.putExtra("usuario_entidad", usuario);
        startActivity(ModificarPerfilActivity);
    }

}
