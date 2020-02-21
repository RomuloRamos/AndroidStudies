package com.example.cardview.model;

public class Postagem {

    private String strNome;
    private String strPostagem;
    private int iImagem;

    public Postagem() {
    }

    public Postagem(String strNome, String strPostagem, int iImagem) {
        this.strNome = strNome;
        this.strPostagem = strPostagem;
        this.iImagem = iImagem;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrPostagem() {
        return strPostagem;
    }

    public void setStrPostagem(String strPostagem) {
        this.strPostagem = strPostagem;
    }

    public int getiImagem() {
        return iImagem;
    }

    public void setiImagem(int iImagem) {
        this.iImagem = iImagem;
    }
}
