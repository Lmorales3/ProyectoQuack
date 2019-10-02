package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.proyectoquack.R;

public class FilaActivity2 extends AppCompatActivity {
    private Float valFila;
    private RatingBar ratingFila;
    private String sssss;
    private TextView valText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fila);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent prev = getIntent();
        String lafila = prev.getStringExtra("quefila");
        ratingFila = (RatingBar) findViewById(R.id.ratingFila);
        TextView infoText = (TextView) findViewById(R.id.text_view_id);
        infoText.setText("Evalúa " + lafila + " de 0 (vacía) a 10 (repleta):");
        valFila = ratingFila.getRating();
        valText = (TextView) findViewById(R.id.textFila);
        //sssss = String.format("%f",valFila);
        valText.setText("" + (int)(valFila*2));//sssss);
        //RatingBar ratingFila = (RatingBar) findViewById(R.id.ratingFila); // initiate a rating bar
        //valFila = ratingFila.getRating(); // get rating number from a rating bar


        ratingFila.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                valText.setText("" + (int)(ratingFila.getRating()*2));
            }
        });
    }

    public void clickRating(View view){
        Intent i = new Intent(this, EstadoFilaActivity.class);
        i.putExtra("nota", (int)(ratingFila.getRating()*2));
        startActivity(i);
        this.finish();
    }


}
