package com.company;

public class Card {
    private String Palo;
    private String Color;
    private String Valor;

    public Card(String color ,String palo, String valor) {
        this.setColor(color);
        this.setPalo(palo);
        this.setValor(valor);
    }

    public void setPalo(String palo) {
        Palo = palo;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getPalo() {
        return Palo;
    }

    public String getValor() {
        return Valor;
    }

    public String getColor() {
        return Color;
    }
}
