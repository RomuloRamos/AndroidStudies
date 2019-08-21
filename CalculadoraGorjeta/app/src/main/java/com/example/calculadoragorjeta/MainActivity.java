package com.example.calculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editGorjeta;
    private TextView textPorcentagem;
    private TextView textGojeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;
    private double dPorcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGorjeta = findViewById(R.id.editValor);
        textGojeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekGorjeta = findViewById(R.id.seekBar);

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dPorcentagem = seekBar.getProgress();
                dPorcentagem = Math.round(dPorcentagem);
                textPorcentagem.setText(dPorcentagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular()
    {
        double dGorjeta;
        //Recuperando Valor
        Double valorDigitado = Double.parseDouble(editGorjeta.getText().toString());
        dGorjeta = (valorDigitado * dPorcentagem)/100;
        dGorjeta = Math.round(dGorjeta);
        textGojeta.setText("R$ "+dGorjeta);
        textTotal.setText("R$ "+(dGorjeta+valorDigitado));
    }


}
