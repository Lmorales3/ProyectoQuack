package com.example.proyectoquack.Activities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Fila;
import com.example.proyectoquack.Entidades.Value;
import com.example.proyectoquack.R;

import java.math.BigInteger;

public class EstadoFilaActivity extends AppCompatActivity {

    private ModelApi modelApi;

    ////
    private float pj, pg;
    private int cj, cg;
    ////

    private NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_fila);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;


        Intent intent = getIntent();
        if (intent.hasExtra("nota")) {

            int nota = intent.getIntExtra("nota",0);
            CharSequence text = "Se envió valoración de " + nota;

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
            ////


            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        ////
        else{
            pj = 0;pg = 0;cj = 0;cg = 0;
        }

        TextView val1 = (TextView) findViewById(R.id.val1);
        TextView val2 = (TextView) findViewById(R.id.val2);
        val1.setText(""+pj);
        val2.setText(""+pg);

        //probando mean_value
        modelApi = new ModelApi();
        Value mem = modelApi.mean_value(0);
        if (mem != null){
            if (intent.getBooleanExtra("quefila",true)){
                val1.setText(""+5.0);
            }
            else{
                val2.setText(""+0.0);
            }
        }


        //una notificación de prueba
        Intent inin = new Intent(this, EstadoFilaActivity.class);
        inin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder = new NotificationCompat.Builder(this, "wew")
                .setSmallIcon(R.drawable.fi2)
                .setContentTitle("Notificación")
                .setContentText("Estado de la fila  ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
    }

    public void clickValor(View view){
        Intent i = new Intent(this, FilaActivity.class);

        ////
        i.putExtra("cj",cj); i.putExtra("pj", pj);
        i.putExtra("cg",cg); i.putExtra("pg", pg);
        ////

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // esto muestra la notificación
        //notificationManager.notify(404, builder.build());

        startActivity(i);
    }

}
