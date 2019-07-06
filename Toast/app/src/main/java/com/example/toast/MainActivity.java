package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view)
    {
        /**
         * Criaçao do Toast
         */
        //Metodo padrão de uso de Toast

        /*Toast.makeText(getApplicationContext(),
                "Botão Pressionado",Toast.LENGTH_LONG).show();*/

        //Metodo de uso do Toast com instanciamento e definiçao
        // de imagem para exibiçao
        ImageView minhaImagem = new ImageView(getApplicationContext());
        minhaImagem.setImageResource(android.R.drawable.star_big_off);

        Toast toastMyToast = new Toast(getApplicationContext());
        toastMyToast.setDuration(Toast.LENGTH_LONG);
        toastMyToast.setView(minhaImagem);
        toastMyToast.show();

    }

}
