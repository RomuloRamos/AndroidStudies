package com.example.pedrapaeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view)
    {
        this.selectedOption("Stone");
    }

    public void selectPaper(View view)
    {
        this.selectedOption("Paper");
    }

    public void selectScissors(View view)
    {
        this.selectedOption("Scissors");
    }

    public void selectedOption(String strUserOption)
    {
        ImageView imgAppChoice = (ImageView)findViewById(R.id.imageResultado);//Resgada o objeto ImageView onde está contida, a princípio, a imagem padrão (vazia) e que depois será alterada
        TextView textResult = (TextView)findViewById(R.id.textResultado); //idem para o text view onde se exibe o resultado

        String[] options = {"Paper", "Stone", "Scissors"};
        int number = new Random().nextInt(3);

        if((number <=2) && (number >= 0)) {
            String appChoice = options[number];

            switch (appChoice)
            {
                case "Paper":
                    imgAppChoice.setImageResource(R.drawable.papel);//Atualiza o drawable (a imagem .png) printada dentro do objeto ImageView
                    break;

                case "Scissors":
                    imgAppChoice.setImageResource(R.drawable.tesoura); //Atualiza o drawable (a imagem .png) printada dentro do objeto ImageView
                    break;

                case "Stone":
                    imgAppChoice.setImageResource(R.drawable.pedra); //Atualiza o drawable (a imagem .png) printada dentro do objeto ImageView
                    break;

                default:
                    System.out.println("Error on function: selectedOption");
                    break;
            }
            if(((appChoice == "Stone")&&(strUserOption == "Paper")) ||//Condições de vitória do usuário
                ((appChoice == "Scissors")&&(strUserOption == "Stone")) ||
                    ((appChoice == "Paper")&&(strUserOption == "Scissors")))
            {
                textResult.setText("Congratulations, You Win!!!");
            }
            else if(((appChoice == "Stone")&&(strUserOption == "Scissors")) ||//Condições de derrota do usuário
                    ((appChoice == "Scissors")&&(strUserOption == "Paper")) ||
                    ((appChoice == "Paper")&&(strUserOption == "Stone")))
            {
                textResult.setText("HAHAHA...You Lose!!!");
            }
            else if(appChoice == strUserOption)//Condições de empate
            {
                textResult.setText("Ow...We have a Draw");
            }
            else System.out.println("Error on choice value at function selectedOption");
        }
        else System.out.println("Error on function: selectedOption");
    }
}
