package com.example.proyectoquack.Activities;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.MyReceiver;
import com.example.proyectoquack.R;
import com.example.proyectoquack.RWSettings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class NotificacionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Usuario usuario;
    private TextView HeaderConductor_username;
    private TextView HeaderConductor_nombre;
    //private TextView usuario1;
    private ImageView HeaderConductor_foto;
    private ModelApi modelApi;

    private boolean doubleBackToExitPressedOnce = false;

    private Switch swn, swg, swj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        usuario = (Usuario)getIntent().getSerializableExtra("usuario_entidad");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        View headView = navigationView.getHeaderView(0);
        HeaderConductor_nombre = (TextView)headView.findViewById(R.id.HeaderConductor_nombre);
        HeaderConductor_username = (TextView)headView.findViewById(R.id.HeaderConductor_username);
        HeaderConductor_foto = (ImageView)headView.findViewById(R.id.HeaderConductor_foto);
        //HeaderConductor_nombre.setText(usuario.getNombre());
        HeaderConductor_foto.setImageResource(R.drawable.user);



        final Context context = getApplicationContext();

        /*
        long sistime = ((long)Math.floor((System.currentTimeMillis() +
                900000/2)/900000) * 900000) + 900000;//para notificar en intervalos de 15 min
         */
        //notificaciones
        Intent notifyIntent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, /*sistime*/System.currentTimeMillis(),
                15 * 1000 * 60/* 60 * 24*/, pendingIntent);
        //900000 milis = 15 min

        /*
        Date d1 = new Date(2019,11,1,0,0),
                d2 = new Date(2019,11,1,0,15),
                d3 = new Date(2019,11,1,0,30,0),
                d4 = new Date(2019,11,1,1,45,0);
        TextView val1 = (TextView) findViewById(R.id.textView10);
        val1.setText(""+d1.getTime()+"\n"+d2.getTime()+"\n"
                +d3.getTime()+"\n"+d4.getTime()+"\n"
                +System.currentTimeMillis()+"\n"
                +sistime);//
        */
        final String activarNotificacion = "actnot.txt";
        final String notifG = "ng.txt";
        final String notifJ = "nj.txt";
        boolean noti = RWSettings.read(activarNotificacion,context,true);
        boolean gral = RWSettings.read(notifG,context,true);
        boolean juna = RWSettings.read(notifJ,context,true);

        swn = (Switch) findViewById(R.id.switch1);
        swn.setChecked(noti);

        swg = (Switch) findViewById(R.id.switch2);
        swg.setChecked(gral);
        swg.setEnabled(noti);

        swj = (Switch) findViewById(R.id.switch3);
        swj.setChecked(juna);
        swj.setEnabled(noti);

        swn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RWSettings.flip(activarNotificacion,context);
                swg.setEnabled(isChecked);
                swj.setEnabled(isChecked);
            }
        });
        swg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RWSettings.flip(notifG,context);
            }
        });
        swj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RWSettings.flip(notifJ,context);
            }
        });
        ///////////***************************
        /*
        try {//leer si notificaciones activadas
            FileInputStream fis = openFileInput(activarNotificacion);
            DataInputStream dis = new DataInputStream(fis);

            Toast toast = Toast.makeText(context, "abierto", Toast.LENGTH_SHORT);
            toast.show();

            boolean actv = dis.readBoolean();

            toast = Toast.makeText(context, "notif es "+actv, Toast.LENGTH_SHORT);
            toast.show();

            dis.close();
        }catch (FileNotFoundException e){
            //Toast toast = Toast.makeText(context, "no se encontró", Toast.LENGTH_SHORT);
            //toast.show();
            try{
                //Toast toast2 = Toast.makeText(context, "crear", Toast.LENGTH_SHORT);
                FileOutputStream fos = openFileOutput(activarNotificacion, MODE_PRIVATE);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBoolean(true);
                dos.flush();
                dos.close();
            } catch (FileNotFoundException f){
                //Toast toast2 = Toast.makeText(context, "no se creó", Toast.LENGTH_SHORT);
                f.printStackTrace();
            } catch (IOException f){
                f.printStackTrace();
            }
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
         */
        ///////////////**************************************************

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Haga clic nuevamente para salir", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.conductor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ConductorActivity_perfil){

            Intent PerfilUsuarioActivity = new Intent(this, PerfilUsuarioActivity.class);
            PerfilUsuarioActivity.putExtra("usuario_entidad", usuario);
            startActivity(PerfilUsuarioActivity);
        }

        else if (id == R.id.ConductorActivity_menu){
            Intent CrearViajeActivity = new Intent(this, EleccionMenuActivity.class);
            CrearViajeActivity.putExtra("usuario_entidad", usuario);
            startActivity(CrearViajeActivity);
        }

        else if (id == R.id.ConductorActivity_verviajes) {
            Intent MisViajesActivity = new Intent(this, FilaActivity.class);
            MisViajesActivity.putExtra("conductor_entidad", usuario);
            startActivity(MisViajesActivity);
        }

       DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}


