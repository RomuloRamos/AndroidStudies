package com.example.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
            super(context, NOME_DB, null, VERSION);
    }

    //O método onCreate é chamado apenas uma vez, quando a aplicação for instalada.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE IF NOT EXISTS "
                + TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " nome TEXT NOT NULL ); ";

        try
        {
            db.execSQL(sql);
            Log.i("INFO DB","Sucesso ao criar tabela");
        }
        catch (Exception e)
        {
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    //Chamado quando a app ja existe mas precisa ser atualizado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql = "DROP TABLE IF EXISTS "
                + TABELA_TAREFAS
                + " ;";

        try
        {
            db.execSQL(sql);
            onCreate(db); //Chama o estado de criação da classe para recriar a tabela
            Log.i("INFO DB","Sucesso ao atualizar App");
        }
        catch (Exception e)
        {
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage());
        }
    }
}
