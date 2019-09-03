package com.example.preferenciasdousuario;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private TextView txtResult;
    private TextInputEditText editName;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";//Declaraçao de constante
    /*
    * O atributo "final" define a variável como como uma constante (imutavel)
    * O atributo "static" define que o valo da variável,
    * em todas as suas instâncias, será o mesmo. Podendo mudar, mas sendo igual entre elas.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.buttonSalvar);
        txtResult = findViewById(R.id.textResultado);
        editName = findViewById(R.id.editNome);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Essa classe cria um arquivo XML para salvar as preferências do usuário
                *Ideal para salvar pequenas informações do usuário.
                */
                SharedPreferences localPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = localPreferences.edit();

                //Validando o nome digitado
                String strName =  editName.getText().toString();
                if(strName.equals(""))//Se o usuário digitou "vazio"
                {
                    Toast.makeText(getApplicationContext(),"Preencha o nome",Toast.LENGTH_LONG).show();
                }
                else
                {
                    editor.putString("nome",strName);
                    editor.commit();
                    txtResult.setText("Olá, " +strName);
                }
            }
        });

        //Recupenrando as preferências
        SharedPreferences localPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //Validar se existe o nome em PREFERENCIAS
        if(localPreferences.contains("nome"))
        {
            String strReturnedName = localPreferences.getString("nome","usuário não definido");
            txtResult.setText("Olá, " + strReturnedName);
        }
        else
        {
            txtResult.setText("Olá, usuário não definido");
        }
    }
}
