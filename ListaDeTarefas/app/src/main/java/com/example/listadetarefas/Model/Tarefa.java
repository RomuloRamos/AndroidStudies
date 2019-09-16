package com.example.listadetarefas.Model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private Long id;
    private String strNomeTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrNomeTarefa() {
        return strNomeTarefa;
    }

    public void setStrNomeTarefa(String strNomeTarefa) {
        this.strNomeTarefa = strNomeTarefa;
    }
}
