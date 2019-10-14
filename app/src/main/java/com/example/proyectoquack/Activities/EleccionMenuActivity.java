package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.R;

public class EleccionMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_menu);
        /*
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_menu);
        *///getSupportActionBar().hide();

    }

    public void JUNAEB(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.MenuJunaebActivity.class);
        startActivity(i);
    }

    public void normal(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.MenuNormalActivity.class);
        startActivity(i);
    }

}
