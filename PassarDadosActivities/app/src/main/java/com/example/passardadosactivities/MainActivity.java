package com.example.passardadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputName;
    private TextInputEditText txtInputAge;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInputName = findViewById(R.id.TextInputNome);
        txtInputAge = findViewById(R.id.TextInputIdade);
        btnSend = findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criando Intent que instancia a segunda activity
                Intent intentSendData = new Intent(getApplicationContext(),SegundaActivity.class);

//                Acrescentando na intent os dados a serem enviados
                intentSendData.putExtra("nome",txtInputName.getText().toString());
                intentSendData.putExtra("idade", txtInputAge.getText().toString());

                startActivity(intentSendData);
            }
        });

    }
}
