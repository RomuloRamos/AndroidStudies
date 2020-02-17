package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listadetarefas.Model.Tarefa;

import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase sqlWrite;
    private SQLiteDatabase sqlRead;

    public TarefaDAO(Context context)
    {
        DbHelper db = new DbHelper(context);
        sqlRead = db.getReadableDatabase();
        sqlWrite = db.getWritableDatabase();
    }

    @Override
    public boolean save(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getStrNomeTarefa());

        try
        {
            sqlWrite.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("LOG INFO", "Tarefa salva com sucesso!");
        }
        catch (Exception e)
        {
            Log.e("LOG INFO", "Erro ao salvar tarefa" + e.getMessage());
            return  false;
        }
        return true;
    }

    @Override
    public boolean update(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean delete(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> list() {
        return null;
    }
}
