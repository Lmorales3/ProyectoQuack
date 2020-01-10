package com.example.proyectoquack;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.proyectoquack.Activities.MainActivity;
import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Value;
import com.example.proyectoquack.RWSettings;

import java.util.Calendar;
import java.util.List;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {



        //api

        /*
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notificacion");
         */


        Calendar quehora = Calendar.getInstance();
        int hora = quehora.get(Calendar.HOUR_OF_DAY);

        Context context = getApplicationContext();
        final String activarNotificacion = "actnot.txt";
        boolean noti = RWSettings.read(activarNotificacion,context,true);

        if (noti && true/*hora >= 11 && hora < 16*/ && Calendar.DAY_OF_WEEK > 1){//horas de notif (11 16)


            /*Toast toast = Toast.makeText(context, "2", Toast.LENGTH_SHORT);
            toast.show();*/
            ModelApi modelApi = new ModelApi();
            List<Comida> comi = modelApi.comidaDelDia();
            Value valu1 = modelApi.mean_value();

            //float fafu = valu1.getValue(); // getvalue me crashea la app :(

            int minuto = quehora.get(Calendar.MINUTE);
            int sec = quehora.get(Calendar.SECOND);



        //RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notificacion);
        //builder.setContent(notificationLayout);


            final String notifG = "ng.txt";
            final String notifJ = "nj.txt";
            boolean gral = RWSettings.read(notifG,context,true);
            boolean juna = RWSettings.read(notifJ,context,true);

            String mensaje = String.format("%02d:%02d:%02d", hora,minuto,sec)/*+ ":"
                    + String.format("%02d", minuto)
                + ":" + String.format("%02d", sec)*/
                    /*+ "\nFila JUNAEB: " //+ valu1.getValue()
                    + "\nFila General:" //+ valu1.getValue()
                    + "\nComida JUNAEB:" + comi.get(0).getNombre_comida() +"\n"+ comi.get(1).getNombre_comida()
                    + "\nComida General:" + comi.get(2).getNombre_comida() +"\n"+ comi.get(4).getNombre_comida()*/;
            if (gral){
                mensaje += "\nFila General:" /*+ valu1.getValue()*/;//"memyfalrtalahapi"
                mensaje += "\nComida General:" + comi.get(2).getNombre_comida()
                    +"\n"+ comi.get(4).getNombre_comida();
            }

            if (juna){
                mensaje += "\nFila JUNAEB: " /*+ valu1.getValue()*/;
                mensaje += "\nComida JUNAEB:" + comi.get(0).getNombre_comida()
                    +"\n"+ comi.get(1).getNombre_comida();
            }
        /*
                + "\nFila JUNAEB: " + valu1.getValue()
                + "\nFila gral:" + valu1.getValue()//"memyfalrtalahapi"
                + "\nComida JUNAEB:" + comi.get(0).getNombre_comida() +"\n"+ comi.get(1).getNombre_comida()
                + "\nComida gral:" + comi.get(2).getNombre_comida() +"\n"+ comi.get(4).getNombre_comida() ;
         */
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

        //if (noti)
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