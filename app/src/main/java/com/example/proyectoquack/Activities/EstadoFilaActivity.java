package com.example.proyectoquack.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Fila;
import com.example.proyectoquack.R;

import java.math.BigInteger;

public class EstadoFilaActivity extends AppCompatActivity {

    private ModelApi modelApi;

    ////
    private float pj, pg;
    private int cj, cg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_fila);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent.hasExtra("nota")) {
            Context context = getApplicationContext();
            int nota = intent.getIntExtra("nota",0);
            CharSequence text = "Se envió valoración de " + nota;
            int duration = Toast.LENGTH_SHORT;

            //BigInteger a = new BigInteger("666");
            //Fila fila = modelApi.obtenerFila(a);

            ////
            cj = intent.getIntExtra("cj",0);
            pj = intent.getFloatExtra("pj",0);
            cg = intent.getIntExtra("cg",0);
            pg = intent.getFloatExtra("pg",0);
            if (intent.getBooleanExtra("quefila",true)){
                pj = (pj*cj + nota)/(cj+1);
                cj += 1;
            }else{
                pg = (pg * cg + nota) / (cg + 1);
                cg += 1;
            }


            Toast toast = Toast.makeText(context, text, duration);
            //toast.show();
        }
        ////
        else{
            pj = 0;pg = 0;cj = 0;cg = 0;
        }

        TextView val1 = (TextView) findViewById(R.id.val1);
        TextView val2 = (TextView) findViewById(R.id.val2);
        val1.setText(""+pj);
        val2.setText(""+pg);

    }

    public void clickValor(View view){
        Intent i = new Intent(this, FilaActivity.class);
        ////
        i.putExtra("cj",cj); i.putExtra("pj", pj);
        i.putExtra("cg",cg); i.putExtra("pg", pg);

        startActivity(i);
    }

}
