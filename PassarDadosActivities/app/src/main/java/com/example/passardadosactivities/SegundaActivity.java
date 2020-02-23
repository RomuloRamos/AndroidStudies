package com.example.passardadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private String strName;
    private String strIdade;
    private TextView txtviewNome;
    private TextView txtviewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtviewNome = findViewById(R.id.textViewOutName);
        txtviewIdade = findViewById(R.id.textViewOutIdade);

        Bundle bReceivedData = getIntent().getExtras();
        strName = bReceivedData.getString("nome");
        strIdade = bReceivedData.getString("idade");

        txtviewNome.setText(strName);
        txtviewIdade.setText(strIdade);
    }
}
