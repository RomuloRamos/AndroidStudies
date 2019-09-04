package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    Context receivedContext;
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";


    public AnotacaoPreferencias(Context c)
    {
        this.receivedContext = c;
        preferences = receivedContext.getSharedPreferences(NOME_ARQUIVO, 0);
        myEdit = preferences.edit();
    }

    public void salvarAnotacao(String anotacao)
    {
        myEdit.putString(CHAVE_NOME, anotacao);
        myEdit.commit();
    }

    public String recuperarAnotacao()
    {

        return preferences.getString(CHAVE_NOME,"");
    }
}
