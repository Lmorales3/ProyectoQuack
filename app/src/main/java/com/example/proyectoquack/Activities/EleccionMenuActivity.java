package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;

public class EleccionMenuActivity extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //CrearViajeActivity.putExtra("usuario_entidad", usuario);
        user = (Usuario)getIntent().getSerializableExtra("usuario_entidad");
    }

    public void JUNAEB(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.MenuNormalActivity.class);
        i.putExtra("usuario_entidad", user);
        i.putExtra("comida_j", (Boolean)true);
        i.putExtra("comida_n", (Boolean)false);
        startActivity(i);
    }

    public void normal(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.MenuNormalActivity.class);
        i.putExtra("usuario_entidad", user);
        i.putExtra("comida_j", (Boolean)false);
        i.putExtra("comida_n", (Boolean)true);
        startActivity(i);
    }

}
