package com.example.listadetarefas.Activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.listadetarefas.Model.Tarefa;
import com.example.listadetarefas.R;
import com.example.listadetarefas.helper.TarefaDAO;

public class AddTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        //Regra para recuperar a tarefa passada, caso a tela seja chamada para editar uma tarefa ja existente
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("TarefaSelecionada");

        //Configurar tarefa recuperada para ediçao na caixa de texto
        if(tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getStrNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.itemSalvar:
                //Executa ação para o caso de Item Salvar selecionado
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if(tarefaAtual != null){ //Editando uma tarefa já existente
                    String nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setStrNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());
                        //Atualizar banco de dados
                        if(tarefaDAO.update(tarefa)){
                            Toast.makeText(AddTarefaActivity.this,"Tarefa atualizada com sucesso!",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(AddTarefaActivity.this,"Erro ao atualizar tarefa",Toast.LENGTH_LONG).show();
                        }
                        finish();
                    }

                }else{ //Criando uma nova tarefa
                    String nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setStrNomeTarefa(nomeTarefa);
                        if(tarefaDAO.save(tarefa)){
                            Toast.makeText(AddTarefaActivity.this,"Tarefa salva com sucesso!",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(AddTarefaActivity.this,"Erro ao salvar tarefa",Toast.LENGTH_LONG).show();
                        }
                        finish();
                    }
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
