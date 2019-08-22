package com.example.caraoucoroa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private int iValue;
    private ImageView imgCoin;
    private Button btVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imgCoin = findViewById(R.id.imageCoin);
        btVoltar = findViewById(R.id.buttonVoltar);

        //recuperando os dados
        Bundle bData = getIntent().getExtras();
        iValue = bData.getInt("numero");
        if(iValue%2 == 0)
        {
            imgCoin.setImageResource(R.drawable.moeda_cara);
        }
        else
        {
            imgCoin.setImageResource(R.drawable.moeda_coroa);
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
