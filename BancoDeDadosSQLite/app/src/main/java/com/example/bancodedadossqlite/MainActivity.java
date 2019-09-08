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
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
//            bancoDados.execSQL("DROP TABLE pessoas");//Comando para apagar tabela


            //Checar se já não ha registros, para não duplicar
            //Recuperar "pessoas"
            /***************************************************************************************
             * O método abaixo é utilzado para recuperar registros do Banco de dados
             ***************************************************************************************/
            String strSqlCommandConsulta =
                    " SELECT * FROM pessoas ";//Seleciona todos os campos "*" da tabela pessoas

            Cursor cursor = bancoDados.rawQuery(strSqlCommandConsulta, null);

            if(cursor.getCount()<=0)
            {
                Log.i("LESSON - ","INSERINDO DADOS NA TABELA...");
                //Inserir dados
                bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Rômulo',29)");
                bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Bianca',32)");
                bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Carlayne',23)");
                bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Wellen',33)");
            }
            else
            {
                Log.i("LESSON - ","TABELA JA PREENCHIDA, NÃO INSERIR, SOMENTE ATUALIZAR...");
                bancoDados.execSQL("UPDATE pessoas SET idade = 33 WHERE nome = 'Wellen'");
            }
            int iLessons = 3;
            for (int iCount = 0; iCount <= iLessons ; iCount++)
            {

                if(iCount == 0)
                {
                    Log.i("LESSON 1 - ","RECUPERANDO OS RESULTADOS INSERIDOS SEM ALTERAÇÃO:");

                }
                else if(iCount == 1)
                {
                    Log.i("LESSON 2 - ","ATUALIZANDO IDADE DE WELLEN PARA 34: ");
                    bancoDados.execSQL("UPDATE pessoas SET idade = 34 WHERE nome = 'Wellen'");
                }
                else if(iCount == 2)
                {
                    Log.i("LESSON 3 -", "APAGANDO LINHA PELO ID: ");
                    bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");
                }
                else if(iCount == 3)
                {
                    Log.i("LESSON 4 - ","APAGANDO TODOS OS REGISTROS...");
                    bancoDados.execSQL("DELETE FROM pessoas");//Apaga todos os itens da tabela
                    bancoDados.execSQL("DELETE FROM sqlite_sequence WHERE name = 'pessoas'");//Apaga os ids autoincrementados
                }
                strSqlCommandConsulta = "SELECT id, nome, idade FROM pessoas "+
                        "WHERE 1=1 ORDER BY id";
                cursor = bancoDados.rawQuery(strSqlCommandConsulta, null);

                //Indices da tabela "pessoas"
                //Relacionar com Array de 2 dimensões, talvez.
                int intIndiceId = cursor.getColumnIndex("id");//Será 0
                int intIndiceNome = cursor.getColumnIndex("nome");//Será 1
                int intIndiceIdade = cursor.getColumnIndex("idade");//Será 2

                cursor.moveToFirst();//Para que o cursor volte a sua posiçao inicial na lista
                int iTotalRows = cursor.getCount();
                for(int iCounterRows = 0; iCounterRows < iTotalRows; iCounterRows++)
                {
                    String strId = cursor.getString(intIndiceId);
                    String strNome = cursor.getString(intIndiceNome);
                    String strIdade = cursor.getString(intIndiceIdade);
                    Log.i("RESULTADO = Id", strId + ") NOME: " + strNome + " ,IDADE: " + strIdade);
                    cursor.moveToNext();//Para que o cursor aponte para a proxima posição
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
