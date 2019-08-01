package com.example.enviandoobjetosentreactivitys;

public class Usuario {

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    String sNome = "Nome indefinido";
    String sEmail = "Email indefinido";

    public Usuario(String sNome, String sEmail)
    {
        this.sNome = sNome;
        this.sEmail = sEmail;
    }

}
