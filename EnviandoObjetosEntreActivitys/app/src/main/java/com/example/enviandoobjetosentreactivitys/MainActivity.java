package com.example.enviandoobjetosentreactivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String sNome = "Rômulo Franklin de Meira Ramos";//Parâmetros Iniciais
    private String sEmail = "romulo.ramos@gee.inatel.br";//Parâmetros Iniciais
    private Button buttonStartButton;//Cria o Botton da primeira Activity

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartButton = findViewById(R.id.MainActButton);//Vincula o button com a View
        buttonStartButton.setOnClickListener(new View.OnClickListener()//Cria o evento de OnClick para o Button
        {
            @Override
            public void onClick(View v)//Define o evento de click
            {
                //Instancia um objeto Intent vinculando-o a Segunda Activity
                Intent intentSecAct = new Intent(getApplicationContext(),SegundaActivity.class);

                //Atribuiçao de dados a Activity de destino
                intentSecAct.putExtra("nome",sNome);
                intentSecAct.putExtra("idade",30);

                startActivity(intentSecAct);//Metodo que starta Activity, recebendo como patâmentro a Activity desejada


            }
        });
    }

}
