package com.example.proyectoquack;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import com.example.proyectoquack.Activities.MainActivity;
import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Value;

import java.util.Calendar;
import java.util.List;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ModelApi modelApi = new ModelApi();
        ;
        List<Comida> comi = modelApi.comidaDelDia();
        //Value valu1 = modelApi.mean_value(0);
        /*
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notificacion");
         */


        Calendar quehora = Calendar.getInstance();
        int hora = quehora.get(Calendar.HOUR_OF_DAY);

        if (hora >= 1 && hora < 16){
        int minuto = quehora.get(Calendar.MINUTE);
        int sec = quehora.get(Calendar.SECOND);



        //RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notificacion);
        //builder.setContent(notificationLayout);


        String mensaje = "Fila JUNAEB: " + hora + ":" + minuto + ":" + sec
                + "\nFila gral:" + "memyfalrtalahapi"//valu1.getValue()
                + "\nComida JUNAEB:" + comi.get(0).getNombre_comida() +"\n"+ comi.get(1).getNombre_comida()
                + "\nComida gral:" + comi.get(2).getNombre_comida() +"\n"+ comi.get(4).getNombre_comida() ;
        /*
        builder.setContentText(mensaje);//comi.get(1).getNombre_comida());
        builder.setSmallIcon(R.drawable.fi2);
        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //to be able to launch your activity from the notification
        builder.setContentIntent(pendingIntent);


        Notification notificationCompat = builder.getNotification();//build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
        */


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