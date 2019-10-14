package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.proyectoquack.R;

public class MenuNormalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escoger_comida);
        //getSupportActionBar().hide();

    }

    public void comidaNormal(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.EleccionMenuActivity.class);
        startActivity(i);
    }

    public void NuevaComida(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.NuevaComidaActivity.class);
        startActivity(i);
    }

}
