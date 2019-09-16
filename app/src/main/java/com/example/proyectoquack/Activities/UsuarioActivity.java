package com.example.proyectoquack.Activities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoquack.Entidades.Usuario;
import com.example.proyectoquack.R;

public class UsuarioActivity extends AppCompatActivity {

    private Usuario conductor;
    private TextView HeaderConductor_username;
    private TextView HeaderConductor_nombre;
    private TextView usuario;
    private ImageView HeaderConductor_foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        conductor=(Usuario) getIntent().getSerializableExtra("conductor_entidad");

        usuario.setText("Bienvenido conductor: " + conductor.getUsername());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
/*
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
            Intent PerfilConductorActivity = new Intent(this, PerfilConductorActivity.class);
            PerfilConductorActivity.putExtra("conductor_entidad", conductor);
            startActivity(PerfilConductorActivity);
        }
        else if (id == R.id.ConductorActivity_crearviaje){
            Intent CrearViajeActivity = new Intent(this, CrearViajeActivity.class);
            CrearViajeActivity.putExtra("conductor_entidad", conductor);
            startActivity(CrearViajeActivity);
        }
        else if (id == R.id.ConductorActivity_verviajes) {
            Intent MisViajesActivity = new Intent(this, MisViajesActivity.class);
            MisViajesActivity.putExtra("conductor_entidad", conductor);
            startActivity(MisViajesActivity);
        }
        else if (id == R.id.ConductorActivity_verreservas) {
            Intent ReservasSolicitadasActivity = new Intent(this, ReservasSolicitadasActivity.class);
            ReservasSolicitadasActivity.putExtra("conductor_entidad", conductor);
            startActivity(ReservasSolicitadasActivity);
        }

        else if (id == R.id.ConductorActivity_salir){
            SharedPreferences sharedPreferences;
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("AutoLogin", false);
            editor.apply();
            Intent MainActivity = new Intent(this, com.example.carpulin.Activities.MainActivity.class);
            startActivity(MainActivity);
            this.finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
