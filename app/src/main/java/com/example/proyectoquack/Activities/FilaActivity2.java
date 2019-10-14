package com.example.proyectoquack.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Fila;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;

import java.math.BigInteger;

public class FilaActivity2 extends AppCompatActivity {
    private Float valFila;
    private RatingBar ratingFila;
    private TextView valText;

    private ModelApi modelApi;
    private Fila fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fila);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent prev = getIntent();
        boolean fi = prev.getBooleanExtra("quefila", false);
        String lafila;
        if (fi){
            lafila = getString(R.string.junaeb);
        }else{
            lafila= getString(R.string.nonaeb);
        }
        ratingFila = (RatingBar) findViewById(R.id.ratingFila);
        TextView infoText = (TextView) findViewById(R.id.text_view_id);
        infoText.setText("Evalúa la fila " + lafila + " de 0 (vacía) a 10 (repleta):");
        valFila = ratingFila.getRating();
        valText = (TextView) findViewById(R.id.textFila);
        valText.setText("" + (int)(valFila*2));

        modelApi = new ModelApi();
        fila = new Fila("404", new Usuario(), "0", 0, fi, !fi);
        //fila = modelApi.crearFila(new Fila());


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

        fila.setPuntaje(ratingFila.getRating()*2);
        Fila fila22 = modelApi.crearFila(fila);

        /*
        Context context = getApplicationContext();  //fila22.setPuntaje(59);
        CharSequence text = "did " + fila22.getPuntaje();   //para cer si funciona crearFila
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        */
        ////
        Intent intent = getIntent();
        i.putExtra("cj",intent.getIntExtra("cj",0));
        i.putExtra("pj", intent.getFloatExtra("pj",0));
        i.putExtra("cg",intent.getIntExtra("cg",0));
        i.putExtra("pg", intent.getFloatExtra("pg",0));
        i.putExtra("quefila", intent.getBooleanExtra("quefila", true));
        ////

        startActivity(i);
        this.finish();
    }


}
