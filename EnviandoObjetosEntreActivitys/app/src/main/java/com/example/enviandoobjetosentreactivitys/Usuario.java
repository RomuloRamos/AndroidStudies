package com.example.enviandoobjetosentreactivitys;

import java.io.Serializable;

public class Usuario implements Serializable
{

    String sNome = "Nome indefinido";
    String sEmail = "Email indefinido";
    String sIdade = "N/A";

    public String getsNome() {
        return sNome;
    }

    public String getsEmail() {
        return sEmail;
    }

    public String getsIdade()
    {
        return this.sIdade;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public void setsIdade(String sIdade)
    {
        this.sIdade = sIdade;
    }

//    public Usuario(String sNome, String sEmail)
//    {
//        this.sNome = sNome;
//        this.sEmail = sEmail;
//    }

}
