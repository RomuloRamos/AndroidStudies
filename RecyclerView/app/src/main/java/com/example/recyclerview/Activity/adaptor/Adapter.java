package com.example.recyclerview.Activity.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Activity.model.Filme;
import com.example.recyclerview.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listFilmes;

    public Adapter(List<Filme> lista)
    {
        this.listFilmes = lista;
    }

    //This method defines the views that will be showed on first access of the
    //activity. After all that, the views will be Recycled with the method onBindViewHolder, and
    //its contents will be exchanged by the new objects of type MyViewHolder.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //This method convert a XML on a View.
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);


        return new MyViewHolder(itemLista);
    }

    //This method is responsible for show the views on object of class MyItemHolder.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listFilmes.get(position);
        holder.txvTitulo.setText(filme.getStrTitulo());
        holder.txvGenero.setText(filme.getStrGenero());
        holder.txvAno.setText(filme.getStrAno());
    }

    //This method returns the quantity of itens to be showed.
    @Override
    public int getItemCount() {
        return listFilmes.size();
    }

    //This class is responsible for create the content object that will be
    //showed in Recycler View. In other words, this class defines the element on the list that
    // will be showed.
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView    txvTitulo;
        TextView    txvAno;
        TextView    txvGenero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txvTitulo = itemView.findViewById(R.id.txvTitulo);
            txvAno = itemView.findViewById(R.id.txvAno);
            txvGenero = itemView.findViewById(R.id.txvGenero);

        }
    }
}
