package com.example.recyclerview.Activity.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filme {

    private String strTitulo;
    private String strGenero;
    private String strAno;

    public Filme(){}

    public Filme(String strTitulo, String strGenero, String strAno) {
        this.strTitulo = strTitulo;
        this.strGenero = strGenero;
        this.strAno = strAno;
    }

    public String getStrTitulo() {
        return strTitulo;
    }

    public void setStrTitulo(String strTitulo) {
        this.strTitulo = strTitulo;
    }

    public String getStrGenero() {
        return strGenero;
    }

    public void setStrGenero(String strGenero) {
        this.strGenero = strGenero;
    }

    public String getStrAno() {
        return strAno;
    }

    public void setStrAno(String strAno) {
        this.strAno = strAno;
    }

    public void setAll(List<String> listAboutFilme)
    {
        this.strTitulo = listAboutFilme.get(0);
        this.strGenero = listAboutFilme.get(1);
        this.strAno = listAboutFilme.get(2);

    }

    public List<String> getAll ()
    {
        List<String> returnList = new ArrayList<>();
        returnList.add(this.strTitulo);
        returnList.add(this.strGenero);
        returnList.add(this.strAno);
        return returnList;

    }
}
