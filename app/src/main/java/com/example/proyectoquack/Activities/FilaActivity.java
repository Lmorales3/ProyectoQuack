package com.example.proyectoquack.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.proyectoquack.R;

public class FilaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.elegir_fila);



    }

    public void onClickJ(View view){
        Intent i = new Intent(this, FilaActivity2.class);
        i.putExtra("quefila", true);
        pasaActivity(i);
        //startActivity(i);
        //this.finish();
    }
    public void onClickO(View view){
        Intent i = new Intent(this, FilaActivity2.class);
        i.putExtra("quefila", false);
        pasaActivity(i);
    }

    public void pasaActivity(Intent i){

        ////
        Intent intent = getIntent();
        i.putExtra("cj",intent.getIntExtra("cj",0));
        i.putExtra("pj", intent.getFloatExtra("pj",0));
        i.putExtra("cg",intent.getIntExtra("cg",0));
        i.putExtra("pg", intent.getFloatExtra("pg",0));

        startActivity(i);

    }


}
