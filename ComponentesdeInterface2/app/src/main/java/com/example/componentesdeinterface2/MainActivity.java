package com.example.componentesdeinterface2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{

    private ToggleButton    toggEstado;
    private Switch          switchEstado;
    private CheckBox        checkEstado;
    private TextView        textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggEstado = findViewById(R.id.toggleButtonEstado);
        switchEstado = findViewById(R.id.switchEstado);
        checkEstado =  findViewById(R.id.checkBoxEstado);
        textResultado = findViewById(R.id.textResultado);
    }



    public void  enviar(View view)
    {
        if(toggEstado.isChecked())
        {
            textResultado.setText("Toggle Ligado");
        }
        else textResultado.setText("Toggle Desligado");

    }
}
