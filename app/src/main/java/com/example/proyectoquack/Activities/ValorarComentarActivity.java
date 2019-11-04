package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.proyectoquack.Entidades.Comida;
import com.example.proyectoquack.Entidades.Publicacion;

import android.widget.EditText;

import com.example.proyectoquack.R;

public class ValorarComentarActivity extends AppCompatActivity {

    private String n;
    private Comida comida;
    private ImageView foto;
    private TextView nombre_comida;
    private RatingBar bar;
    private EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_valorar_comida);

        comida = (Comida)getIntent().getSerializableExtra("comida");
        n = comida.getNombre_comida();

        foto = (ImageView)findViewById(R.id.foto_comida_valorada);
        nombre_comida = (TextView)findViewById(R.id.comida_valorada);

        nombre_comida.setText(n);
        set_foto(foto, n);

        bar = (RatingBar)findViewById(R.id.ratingComida);

       // comentario = (TextInputLayout)findViewById(R.id.comentar_comida);

    }

    private void set_foto(ImageView f, String nombre){
        if(nombre.equals("Porotos")) f.setImageResource(R.drawable.porotos);
        else if( nombre.equals("Tallarines con salsa") ) f.setImageResource(R.drawable.tallarinessalsa);
        else if( nombre.equals("Papas fritas con pollo") ) f.setImageResource(R.drawable.papasconpoio);
        else if( nombre.equals("Puré con huevo") ) f.setImageResource(R.drawable.purechuevo);
        else f.setImageResource(R.drawable.sincomida);
    }

    public void update_bar(View view){

    }

    public void publicar_valoracion(View view){
        float valoracion = (float)bar.getRating();
        String coment = comentario.getText().toString();
        Publicacion pub = new Publicacion();
    }

    public void comidaJuna_valorar(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.EleccionMenuActivity.class);
        startActivity(i);
    }


    public void comidaNormal_valorar(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.EleccionMenuActivity.class);
        startActivity(i);
    }

}
