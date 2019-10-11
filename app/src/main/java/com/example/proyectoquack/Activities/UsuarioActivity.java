package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
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
import com.example.proyectoquack.R;

public class UsuarioActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView(R.layout.activity_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        usuario = (Usuario)getIntent().getSerializableExtra("usuario_entidad");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        modelApi= new ModelApi();
        Usuario usuario2 = modelApi.obtenerUsuario(usuario.getNombre_usuario());

        navigationView.setNavigationItemSelectedListener(this);


        View headView = navigationView.getHeaderView(0);
        HeaderConductor_nombre = (TextView)headView.findViewById(R.id.HeaderConductor_nombre);
        HeaderConductor_username = (TextView)headView.findViewById(R.id.HeaderConductor_username);
        HeaderConductor_foto = (ImageView)headView.findViewById(R.id.HeaderConductor_foto);
       // HeaderConductor_username.setText((CharSequence) usuario2);
        //HeaderConductor_nombre.setText(usuario.getNombre());
        HeaderConductor_foto.setImageResource(R.drawable.user);


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


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ConductorActivity_perfil){
            Intent PerfilUsuarioActivity = new Intent(this, PerfilUsuarioActivity.class);
            PerfilUsuarioActivity.putExtra("usuario_entidad", usuario);
            startActivity(PerfilUsuarioActivity);
        }



        /*
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
            Intent MainActivity = new Intent(this, com.example.proyectoquack.Activities.MainActivity.class);
            startActivity(MainActivity);
            this.finish();
        }
*/
       DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
