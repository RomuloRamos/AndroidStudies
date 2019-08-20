package com.example.enviandoobjetosentreactivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade, textEmail;
    private Usuario secActUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textIdade = findViewById(R.id.SecActIdade);
        textNome = findViewById(R.id.SecActNome);
        textEmail = findViewById(R.id.secActEmail);

        //Recuperando os Dados enviados pela primeira Activity (Para isso utiliza-se Bundle)
        Bundle dados = getIntent().getExtras();

        secActUsuario = (Usuario)dados.get("user");
//        String name = dados.getString("nome");
//        int iAge = dados.getInt("idade");

        //Configurando valores recebino na Activity
        textNome.setText(secActUsuario.getsNome());
        textIdade.setText(secActUsuario.getsIdade());
        textEmail.setText(secActUsuario.getsEmail());
    }
}
