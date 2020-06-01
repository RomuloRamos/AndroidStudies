package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listadetarefas.Model.Tarefa;

import java.util.ArrayList;
import java.util.List;
//Data Access Object Class
public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase sqlWriteTable;
    private SQLiteDatabase sqlReadTable;

    public TarefaDAO(Context context)
    {
        DbHelper db = new DbHelper(context);
        sqlReadTable = db.getReadableDatabase();
        sqlWriteTable = db.getWritableDatabase();
    }

    @Override
    public boolean save(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getStrNomeTarefa());

        try
        {
            sqlWriteTable.insert(DbHelper.TABELA_TAREFAS, null, cv);
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
        ContentValues cv = new ContentValues();
//        cv.put("id", tarefa.getId());
        cv.put("nome", tarefa.getStrNomeTarefa());
        try
        {
            String[] args = {tarefa.getId().toString()};//Array de strings com os parâmetros da query "whereClause"
            sqlWriteTable.update(DbHelper.TABELA_TAREFAS, cv,"id=?", args);
            Log.i("LOG INFO", "Tarefa atualizada com sucesso!");
        }
        catch (Exception e)
        {
            Log.e("LOG INFO", "Erro ao atualizar tarefa" + e.getMessage());
            return  false;
        }
        return true;
    }

    @Override
    public boolean delete(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> list() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM "+ DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = sqlReadTable.rawQuery(sql, null);

        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();
            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setStrNomeTarefa(nomeTarefa);
            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
