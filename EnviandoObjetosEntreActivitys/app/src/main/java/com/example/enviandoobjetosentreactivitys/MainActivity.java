package com.example.enviandoobjetosentreactivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartButton;//Cria o Botton da primeira Activity
    EditText txtNome;
    EditText txtEmail;
    EditText txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Usuario mainActUsuario = new Usuario();

        txtNome = findViewById(R.id.txtNome);//Vincula o campo TextView de nome;
        txtEmail = findViewById(R.id.txtEmail);//Vincula o campo TextView de email;
        txtIdade = findViewById(R.id.txtIdade);//Vincula o campo TextView de idade;

        buttonStartButton = findViewById(R.id.MainActButton);//Vincula o button com a View
        buttonStartButton.setOnClickListener(new View.OnClickListener()//Cria o evento de OnClick para o Button
        {
            @Override
            public void onClick(View v)//Define o evento de click
            {
                mainActUsuario.setsEmail(txtEmail.getText().toString());
                mainActUsuario.setsIdade(txtIdade.getText().toString());
                mainActUsuario.setsNome(txtNome.getText().toString());

                //Instancia um objeto Intent vinculando-o a Segunda Activity
                Intent intentSecAct = new Intent(getApplicationContext(),SegundaActivity.class);

                //Atribuiçao de dados a Activity de destino
                intentSecAct.putExtra("user",mainActUsuario);

                startActivity(intentSecAct);//Metodo que starta Activity, recebendo como patâmentro a Activity desejada
            }
        });
    }

}
