package com.example.recyclerview.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.recyclerview.Activity.adaptor.Adapter;
import com.example.recyclerview.Activity.model.Filme;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurando o Adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    public void criarFilmes()
    {
        Filme filme = new Filme("Titulo-1", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-2", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-3", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-4", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-5", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-6", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-7", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-8", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-9", "Genero", "Ano");
        this.listaFilmes.add(filme);
        filme = new Filme("Titulo-10", "Genero", "Ano");
        this.listaFilmes.add(filme);

        for(int iCount = 11; iCount < 50; iCount++)
        {
            filme = new Filme("Titulo-"+iCount, "Genero", "Ano");
            this.listaFilmes.add(filme);
        }

    }
}
