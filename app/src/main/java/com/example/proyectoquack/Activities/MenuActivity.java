package com.example.proyectoquack.Activities;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

        protected void onCreate(){

        }

        public void onClickJuna(View view){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Prueba JUNA", Toast.LENGTH_SHORT);
           // toast1.setGravity(Gravity.CENTER);

            toast1.show();
        }
}
