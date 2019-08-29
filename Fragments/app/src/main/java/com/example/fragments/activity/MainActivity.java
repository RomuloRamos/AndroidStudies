package com.example.fragments.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.R;
import com.example.fragments.fragment.ContatosFragment;
import com.example.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnConversa, btnContatos;
    private ConversasFragment   frgmConversas;
    private ContatosFragment    frgmContato;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover a sombra da ActionBar
        getSupportActionBar().setElevation(0);

        btnContatos = findViewById(R.id.btnContatos);
        btnConversa = findViewById(R.id.btnConversa);

        frgmConversas = new ConversasFragment();

        //Configurar objeto para o Fragmento
        transaction = getSupportFragmentManager().beginTransaction(); //Indica o inicio da alteraçao de um fragment
        transaction.replace(R.id.frameConteudo, frgmConversas); //Recebe o espaço onde será aplicado o fragmento e o proprio fragment
        transaction.commit();//Commita a mudança no espaço do fragment

        //Configuraçao de botoes para fragmentos
        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frgmContato = new ContatosFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, frgmContato);
                transaction.commit();
            }
        });

        btnConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, frgmConversas);
                transaction.commit();
            }
        });
    }
}
