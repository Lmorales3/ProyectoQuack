package com.example.proyectoquack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.ImageView;
import com.example.proyectoquack.Entidades.Comida;
import android.widget.TextView;

import com.example.proyectoquack.DB.ModelApi;
import com.example.proyectoquack.R;


import java.util.List;

public class MenuNormalActivity extends AppCompatActivity {

    private List<Comida> comidas;
    private TextView comida1, comida2, comida3, comida4;
    private ImageView foto1, foto2, foto3, foto4;
    private ModelApi modelApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escoger_comida);

        modelApi = new ModelApi();
        comida1 = (TextView)findViewById(R.id.texto_comida1);
        comida2 = (TextView)findViewById(R.id.texto_comida2);
        comida3 = (TextView)findViewById(R.id.texto_comida3);
        comida4 = (TextView)findViewById(R.id.texto_comida4);

        foto1 = ((ImageView)findViewById(R.id.foto_comida1));
        foto2 = ((ImageView)findViewById(R.id.foto_comida2));
        foto3 = ((ImageView)findViewById(R.id.foto_comida3));
        foto4 = ((ImageView)findViewById(R.id.foto_comida4));

        comidas = modelApi.comidaDelDia();

        comida1.setText( comidas.get(0).getNombre_comida() );
        comida2.setText( comidas.get(1).getNombre_comida() );
        comida3.setText( comidas.get(2).getNombre_comida() );
        comida4.setText( comidas.get(3).getNombre_comida() );

        set_foto(foto1, comidas.get(0).getNombre_comida());
        set_foto(foto2, comidas.get(1).getNombre_comida());
        set_foto(foto3, comidas.get(2).getNombre_comida());
        set_foto(foto4, comidas.get(3).getNombre_comida());


        //getSupportActionBar().hide();

    }

    public void valorar_comida_normal(View view){
        Intent i = new Intent(this, ValorarComentarActivity.class);
        String tag = (String) view.getTag();
        i.putExtra("nombre", tag);
        startActivity(i);

    }

    private void set_foto(ImageView f, String nombre){
        f.setTag(nombre);
        if(nombre.equals("Porotos")) f.setImageResource(R.drawable.porotos);
        else if( nombre.equals("Tallarines con salsa") ) f.setImageResource(R.drawable.tallarinessalsa);
        else if( nombre.equals("Papas fritas con pollo") ) f.setImageResource(R.drawable.papasconpoio);
        else if( nombre.equals("Puré con huevo") ) f.setImageResource(R.drawable.purechuevo);
        else f.setImageResource(R.drawable.sincomida);
    }


    public void NuevaComida(View view){
        Intent i = new Intent(this, com.example.proyectoquack.Activities.ValorarComentarActivity.class);
        startActivity(i);
    }

}
