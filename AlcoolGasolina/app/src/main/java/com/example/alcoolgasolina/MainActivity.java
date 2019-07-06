package com.example.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relaciona as variaveis locais às Views do activit_main.xml
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view)
    {
        String strValueGasoline = editPrecoGasolina.getText().toString();
        String strValueAlcool = editPrecoAlcool.getText().toString();
        Double dResult;
        int iResult;
        if(this.bValuesValidation(strValueGasoline,strValueAlcool))
        {
            dResult = ((Double.parseDouble(strValueAlcool))/(Double.parseDouble(strValueGasoline)));
            iResult = (int) Math.round(dResult*100);
            dResult = (double)iResult;
            dResult = (dResult/100);

            if(dResult >= 0.7) {
                this.textResultado.setText("Relaçao de: "+Double.toString(dResult)+"\nUse Gasolina!");
            }
            else
            {
                this.textResultado.setText("Relaçao de: "+Double.toString(dResult)+"\nUse Alcool!");
            }
        }
        else
        {
            this.textResultado.setText("Adione valores válidos de Alcool e Gasolina.");
        }
    }

    private Boolean bValuesValidation(String strValueGasoline, String strValueAlcool)
    {
        if((strValueAlcool == null) || (strValueGasoline == null) || (strValueAlcool.equals("")) || (strValueGasoline.equals("")))
        {
            return false;
        }
        else return true;
    }
}
