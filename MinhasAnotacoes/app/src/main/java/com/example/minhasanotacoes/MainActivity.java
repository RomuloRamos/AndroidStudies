package com.example.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias AnotacaoPreferencias;
    private EditText editAnotacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        AnotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se existe Texto
                String strText = editAnotacao.getText().toString();
                if(strText.equals(""))
                {
                    Snackbar.make(view, "Nada para ser salvo", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    AnotacaoPreferencias.salvarAnotacao(strText);
                    Snackbar.make(view, "Texto salvo com sucesso", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //Recuperar a anotacao
        String strAnotacao = AnotacaoPreferencias.recuperarAnotacao();
        if(!strAnotacao.equals(""))
        {
            editAnotacao.setText(strAnotacao);
        }
    }

}
