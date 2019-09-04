package com.example.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try//É uma boa prática, ao lidar com Banco de Dados, utilizar a estrutura "try/catch"
        {
            //ABRE UM BANCO, OU CRIA, CASO NÃO EXISTA
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE,null);

            //Cria a tabela
            /***************************************************************************************
            * O método abaixo executa comando SQL que recebe como parâmetro.
            ***************************************************************************************/
            /***************************************************************************************
            * Os comandos da sintaxe SQL estão em letra maiúscula e os parâmetros em minusculo
            * Abaixo, é criada uma tabale com o nome "pessoas", somente se a tabela não existir, e
            * com duas colunas: nome (do tipo string), e uma idade (do tipo INT com limitaçao de 3
            * algarismos, ex: "999")
            ***************************************************************************************/
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            //Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Rômulo',29)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Bianca',32)");

            //Recuperar "pessoas"
            /***************************************************************************************
            * O método abaixo é utilzado para recuperar registros do Banco de dados
            ***************************************************************************************/
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas",null);

            //Indices da tabela "pessoas"
            //Relacionar com Array de 2 dimensões, talvez.
            int intIndiceNome = cursor.getColumnIndex("nome");//Será 0
            int intIndiceIdade = cursor.getColumnIndex("idade");//Será 1

            cursor.moveToFirst();//Para que o cursor volte a sua posiçao inicial na lista

            while (cursor != null)
            {
                String strNome = cursor.getString(intIndiceNome);
                String strIdade = cursor.getString(intIndiceIdade);
                Log.i("RESULTADO = Nome ", strNome + "idade: " + strIdade);
                cursor.moveToNext();//Para que o cursor aponte para a proxima posição
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
