package com.example.enviandoobjetosentreactivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textIdade = findViewById(R.id.SecActIdade);
        textNome = findViewById(R.id.SecActNome);

        //Recuperando os Dados enviados pela primeira Activity (Para isso utiliza-se Bundle)
        Bundle dados = getIntent().getExtras();
        String name = dados.getString("nome");
        int iAge = dados.getInt("idade");

        //Configurando valores recebino na Activity
        textNome.setText(name);
        textIdade.setText(String.valueOf(iAge));
    }
}