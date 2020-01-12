package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ElegirPublicacionActivity extends AppCompatActivity {

    public void EscogerPublicacion(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.ComentarActivity.class);
        startActivity(i);
    }

}
