package com.example.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textResultado = findViewById(R.id.textResultado);

        //Cria um ouvinte para as mudanças do seekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textResultado.setText("Progresso: "+ seekBar.getProgress() + " / " + seekBar.getMax());
            }

            @Override //Metodo para evento de início de alteraçao do SeekBar
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Seekbar alterado", Toast.LENGTH_SHORT).show();
            }

            @Override //Metodo para quando o seekbar não está mais pressionado
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Seekbar não pressionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
