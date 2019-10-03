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



        /*setContentView(R.layout.activity_fila);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RatingBar ratingFila = (RatingBar) findViewById(R.id.ratingFila); // initiate a rating bar
        Float ratingNumber = ratingFila.getRating(); // get rating number from a rating bar
*/

        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         */
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
        startActivity(i);
    }


}
