package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


        public void onClickMenu(View view){
            Intent i = new Intent(this, com.example.proyectoquack.Activities.EleccionMenuActivity.class);
            startActivity(i);
        }
}
