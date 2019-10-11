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

/*
        username.setText("Usuario: " + usuario.getNombre_usuario());
        nombre.setText("Nombre: " +usuario.getNombre_real());
        telefono.setText("Fecha de nacimiento: " +usuario.getFecha_nacimiento());
        correo.setText("Correo: " +usuario.getCorreo());
        carrera.setText("Carrera: " +usuario.getCarrera());
        Almuerzos_preferidos.setText("Almuerzo Preferido: Croquetas de jurel con caracolitos pomodoro");
        Quack_puntos.setText("QuackPoints: 100");
*/
        username.setText("Usuario: Andres" );
        nombre.setText("Nombre: Andres Stuardo");
        telefono.setText("Fecha de nacimiento: 08/09/95 ");
        correo.setText("Correo: astuardo@udec.cl");
        carrera.setText("Carrera: Geofísica");
        Almuerzos_preferidos.setText("Almuerzo Preferido: Croquetas de jurel con caracolitos pomodoro");
        Quack_puntos.setText("QuackPoints: 100");




    }


    public void modificarPerfil(View view){
        Intent ModificarPerfilActivity = new Intent(this, ModificarPerfilActivity.class);
        ModificarPerfilActivity.putExtra("usuario_entidad", usuario);
        startActivity(ModificarPerfilActivity);
    }

}
