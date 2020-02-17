package com.example.listadetarefas.helper;

import com.example.listadetarefas.Model.Tarefa;

import java.util.List;

public interface ITarefaDAO {

    public boolean save(Tarefa tarefa);
    public boolean update(Tarefa tarefa);
    public boolean delete(Tarefa tarefa);
    public List<Tarefa> list();

}
