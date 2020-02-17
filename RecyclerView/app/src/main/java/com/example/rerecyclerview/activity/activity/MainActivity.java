package com.example.rerecyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rerecyclerview.R;
import com.example.rerecyclerview.activity.RecyclerItemClickListener;
import com.example.rerecyclerview.activity.adapter.Adapter;
import com.example.rerecyclerview.activity.model.Filme;

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
        this.CriarFilmes();

        //Configurando adapter
        Adapter adapter = new Adapter(listaFilmes);
        //Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void CriarFilmes(){
        Filme filme = new Filme("Hereditário","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("A Bruxa","Terror","2015");
        this.listaFilmes.add(filme);
        filme = new Filme("A Entidade","Terror","2012");
        this.listaFilmes.add(filme);
        filme = new Filme("O Lamento","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("O Babadook","Terror","2014");
        this.listaFilmes.add(filme);
        filme = new Filme("Corra!","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("REC","Terror","2007");
        this.listaFilmes.add(filme);
        filme = new Filme("A Mão do Diabo","Terror","2001");
        this.listaFilmes.add(filme);
        filme = new Filme("Invocação do Mal","Terror","2013");
        this.listaFilmes.add(filme);
        filme = new Filme("Amanhecer dos Mortos","Terror","2004");
        this.listaFilmes.add(filme);
        filme = new Filme("Midsommar – O Mal não Espera a Noite","Terror","2019");
        this.listaFilmes.add(filme);
        filme = new Filme("Hereditário","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("REC 2: Possuídos","Terror","2009");
        this.listaFilmes.add(filme);
        filme = new Filme("Caçador de Trolls","Terror","2010");
        this.listaFilmes.add(filme);
        filme = new Filme("Invasão Zumbi","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("Um Lugar Silencioso","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("Corrente do Mal","Terror","2014");
        this.listaFilmes.add(filme);
        filme = new Filme("O Segredo da Cabana","Terror","2011");
        this.listaFilmes.add(filme);
        filme = new Filme("Rua Cloverfield, 10","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("It","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Deixe-me Entrar","Terror","2010");
        this.listaFilmes.add(filme);
        filme = new Filme("Extermínio","Terror","2002");
        this.listaFilmes.add(filme);
        filme = new Filme("Garota Sombria Caminha pela Noite","Terror","2014");
        this.listaFilmes.add(filme);
        filme = new Filme("O Chamado","Terror","2002");
        this.listaFilmes.add(filme);
        filme = new Filme("Deixa Ela Entrar","Terror","2008");
        this.listaFilmes.add(filme);
        filme = new Filme("A Espinha do Diabo","Terror","2001");
        this.listaFilmes.add(filme);
        filme = new Filme("Contos do Dia das Bruxas","Terror","2007");
        this.listaFilmes.add(filme);
        filme = new Filme("A Hospedeira","Terror","2013");
        this.listaFilmes.add(filme);
        filme = new Filme("O Nevoeiro","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Dia das Bruxas","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("Arraste-me para o Inferno","Terror","2009");
        this.listaFilmes.add(filme);
        filme = new Filme("Aniquilação","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("O que Fazemos nas Sombras","Terror","2014");
        this.listaFilmes.add(filme);
        filme = new Filme("Suspiria","Terror","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("O Sacrifício do Cervo Sagrado","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("It: Capítulo 2","Terror","2019");
        this.listaFilmes.add(filme);
        filme = new Filme("Abismo do Medo","Terror","2005");
        this.listaFilmes.add(filme);
        filme = new Filme("Guardiões da Noite","Terror","2004");
        this.listaFilmes.add(filme);
        filme = new Filme("Raw","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("Fragmentado","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("Ouija 2","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("A Epidemia","Terror","2010");
        this.listaFilmes.add(filme);
        filme = new Filme("Nós","Terror","2019");
        this.listaFilmes.add(filme);
        filme = new Filme("Atividade Paranormal","Terror","2007");
        this.listaFilmes.add(filme);
        filme = new Filme("Possessão","Terror","2012");
        this.listaFilmes.add(filme);
        filme = new Filme("O Homem nas Trevas","Terror","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("O Último Exorcismo","Terror","2010");
        this.listaFilmes.add(filme);
        filme = new Filme("Todo Mundo Quase Morto","Terror","2004");
        this.listaFilmes.add(filme);
        filme = new Filme("Prometeu","Terror","2012");
        this.listaFilmes.add(filme);
        filme = new Filme("Alien: Covenant","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Guerra Mundial Z","Terror","2013");
        this.listaFilmes.add(filme);

    }
}
