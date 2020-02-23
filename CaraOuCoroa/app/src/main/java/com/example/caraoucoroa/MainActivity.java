package com.example.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/*Como o intuito deste App é treinar o envio de informaçoes de uma Activity para outra,
*optou-se por gerar o número randomico que define o lado Cara ou Coroa na MainActivity
*para que o mesmo seja enviado para a ActivityResultado.
*/
public class MainActivity extends AppCompatActivity {

    private Button btJogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJogar = findViewById(R.id.button_Jogar);

        btJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando a Intent que envia o numero Randomico para a ActivityResultado
                Intent intentResultado = new Intent(getApplicationContext(), ResultadoActivity.class);

                //Gerando o numero randomico que resulta em cara ou coroa
                int iNumber = new Random().nextInt(10);
//                Log.d("MainActivity","Value Random is>>>>>>>>>>>>>>>>>>>> "+ iNumber);
                intentResultado.putExtra("numero",iNumber);

                startActivity(intentResultado);
            }
        });
    }
}
