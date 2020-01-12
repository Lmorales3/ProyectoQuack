package com.example.proyectoquack.Notificaciones;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.proyectoquack.Activities.MainActivity;
import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Value;
import com.example.proyectoquack.R;

import java.util.Calendar;
import java.util.List;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Calendar quehora = Calendar.getInstance();
        int hora = quehora.get(Calendar.HOUR_OF_DAY);

        Context context = getApplicationContext();
        final String activarNotificacion = "actnot.txt";
        boolean noti = RWSettings.read(activarNotificacion,context,true);

        if (noti && hora >= 11 && hora < 16 && Calendar.DAY_OF_WEEK > 1){

            ModelApi modelApi = new ModelApi();
            List<Comida> comi = modelApi.comidaDelDia();
            Value valu1 = modelApi.mean_value();
            //float fafu = valu1.getValue(); // getvalue me crashea la app :(

            int minuto = quehora.get(Calendar.MINUTE);
            int sec = quehora.get(Calendar.SECOND);

            final String notifG = "ng.txt";
            final String notifJ = "nj.txt";
            boolean gral = RWSettings.read(notifG,context,true);
            boolean juna = RWSettings.read(notifJ,context,true);

            String mensaje = String.format("%02d:%02d:%02d", hora,minuto,sec);
            if (gral){
                mensaje += "\nFila General: 0" /*+ valu1.getValue()*/;
                mensaje += "\nComida General: " + comi.get(2).getNombre_comida()
                    +"\n"+ comi.get(4).getNombre_comida();
            }

            if (juna){
                mensaje += "\nFila JUNAEB: 0" /*+ valu1.getValue()*/;
                mensaje += "\nComida JUNAEB: " + comi.get(0).getNombre_comida()
                    +"\n"+ comi.get(1).getNombre_comida();
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this);
            Intent notifyIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = builder.setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.fi3).setTicker("Quack").setWhen(0)
                    .setAutoCancel(true).setContentTitle("Quack")
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(mensaje))
                    .setContentText(mensaje).build();

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(NOTIFICATION_ID, notification);

    }

    }
}