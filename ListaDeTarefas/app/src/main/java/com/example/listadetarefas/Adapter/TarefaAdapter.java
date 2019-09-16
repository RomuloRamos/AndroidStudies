package com.example.listadetarefas.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.listadetarefas.Model.Tarefa;
import com.example.listadetarefas.R;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    private List<Tarefa> listTarefa;

    public TarefaAdapter(List<Tarefa> listTarefas)
    {
        this.listTarefa = listTarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_tarefa_adapter, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Tarefa tarefa = listTarefa.get(i);
        myViewHolder.tarefa.setText(tarefa.getStrNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return this.listTarefa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tarefa = itemView.findViewById(R.id.textViewTarefa);

        }
    }
}
