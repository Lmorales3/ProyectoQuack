package com.example.proyectoquack.Activities;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.MyReceiver;
import com.example.proyectoquack.R;

import java.util.Date;

public class NotificacionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Usuario usuario;
    private TextView HeaderConductor_username;
    private TextView HeaderConductor_nombre;
    //private TextView usuario1;
    private ImageView HeaderConductor_foto;
    private ModelApi modelApi;

    private boolean doubleBackToExitPressedOnce = false;


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


        Context context = getApplicationContext();

        long sistime = ((long)Math.floor((System.currentTimeMillis() +
                900000/2)/900000) * 900000) + 900000;//para notificar en intervalos de 15 min

        Intent notifyIntent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, /*sistime*/System.currentTimeMillis(),
                15 * 1000 * 60 /* 60 * 24*/, pendingIntent);
        //900000 milis = 15 min
        Date d1 = new Date(2019,11,1,0,0),
                d2 = new Date(2019,11,1,0,15),
                d3 = new Date(2019,11,1,0,30,0),
                d4 = new Date(2019,11,1,1,45,0);
        TextView val1 = (TextView) findViewById(R.id.textView10);
        val1.setText(""+d1.getTime()+"\n"+d2.getTime()+"\n"
                +d3.getTime()+"\n"+d4.getTime()+"\n"
                +System.currentTimeMillis()+"\n"
                +sistime);//

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


