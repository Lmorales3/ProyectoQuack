package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.proyectoquack.R;

public class ValorarComentarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_valorar_comida);
        //getSupportActionBar().hide();

    }

    public void comidaJuna(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.EleccionMenuActivity.class);
        startActivity(i);
    }

}
