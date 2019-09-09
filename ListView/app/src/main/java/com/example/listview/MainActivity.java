package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {"Ubatuba","Manaus","Pouso Alegre","Santa Rita do Sapucaí",
            "Nova Mutum","Luiz Eduardo Magalhães","Uruçuí","Balsas","Imperatriz",
            "Lucas do Rio Verde", "Barra do Garça"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //Criar adaptador para a Lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens);

        //Acionat Adaptador na Lista
        listLocais.setAdapter(adaptador);

        // Adicionar clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),valorSelecionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
