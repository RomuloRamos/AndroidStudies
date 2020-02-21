package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.R;
import com.example.cardview.adapter.PostagemAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> listPostagens = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);

        this.addPostagem();
        //Define Adapter
        PostagemAdapter adapter = new PostagemAdapter(this.listPostagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void addPostagem(){

        Postagem p = new Postagem("Rômulo Ramos", "Show de bola", R.drawable.imagem1);
        this.listPostagens.add(p);

        p = new Postagem("Laíza Mourão", "Também gostei", R.drawable.imagem2);
        this.listPostagens.add(p);

        p = new Postagem("Felipe Lemes", "Na próxima me chama", R.drawable.imagem3);
        this.listPostagens.add(p);

        p = new Postagem("Chalinhos", "Gosto mais de batata e gosto mais de estudar também!", R.drawable.imagem4);
        this.listPostagens.add(p);

    }
}
