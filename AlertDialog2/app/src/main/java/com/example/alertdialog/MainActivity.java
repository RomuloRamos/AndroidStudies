package com.example.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlerta(View view)
    {
        /*
        * Criar AlertDialog
        * Intancia um objeto Buider em (e) um objeto AlertDialog.
        * Nesse caso, passando o contexto "this", passa-se como parâmetro o contexto local da
        * classe MainActivity, e não o contexto global (com getApplicationContext).
        */
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //Configurando o título e a mensagem
        dialog.setTitle("Título");
        dialog.setMessage("Mensagem");

        //Configura CANCELAMENTO
        dialog.setCancelable(false);//Dessa maneira não é possivel cancelar a AlertDialog clicando fora dela

        //Configura Ícone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);//Icone ao lado do titulo

        //Configuando ações dos botões
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"A opção Sim foi pressionada", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"A opção Não foi pressionada", Toast.LENGTH_SHORT).show();
            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }

}
