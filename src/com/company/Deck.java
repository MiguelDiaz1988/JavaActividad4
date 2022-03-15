package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> Deck = new ArrayList<Card>();

    public Deck() {
        var palosDisponibles = new ArrayList<String>() {{
            add("Tréboles");
            add("Corazones");
            add("Picas");
            add("Diamantes");
        }};

        var valoresDisponibles = new ArrayList<String>(){{
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
            add("10");
            add("A");
            add("J");
            add("Q");
            add("K");
        }};


        palosDisponibles.forEach((palo)->{
            valoresDisponibles.forEach((valor)->{
                var color = "Negro";
                if (palo == "Corazones" || palo == "Diamantes") {
                    color = "Rojo";
                }

                Deck.add(new Card(color, palo, valor));
            });
        });

    }

    public void Shuffle() {
        Collections.shuffle(Deck);
        System.out.println("Se mezcló el Deck");
    }

    public void Hand() {
        if(Deck.size() < 5 ) {
            System.out.println("Ya no quedan suficientes cartas en el deck");
            return;
        }

        for(int i=0; i < 5; i++) {
            var carta = this.sacarCartaRandom();
            this.imprimirCarta(carta);
        }

        this.imprimirCuantoQueda();
    }

    public void Pick() {
        if(Deck.size() == 0 ) {
            System.out.println("Ya no quedan cartas en el deck");
            return;
        }

        var carta = this.sacarCartaRandom();
        this.imprimirCarta(carta);
        this.imprimirCuantoQueda();
    }

    public void Head() {
        if(Deck.size() == 0 ) {
            System.out.println("Ya no quedan cartas en el deck");
            return;
        }

        var carta = this.sacarCarta(0);
        this.imprimirCarta(carta);
        this.imprimirCuantoQueda();

    }

    private void imprimirCarta(Card carta){
        System.out.println(carta.getPalo() + "," + carta.getColor() + "," + carta.getValor());
    }

    private void imprimirCuantoQueda() {
        System.out.println("Quedan: " + Deck.size()  + " cartas en deck");
    }

    private Card sacarCarta(int index) {
        var cartaSeleccionada =  Deck.get(index);
        Deck.remove(index);
        return cartaSeleccionada;
    }

    private Card sacarCartaRandom() {
        var max = Deck.size() - 1;
        var min = 0;

        var randomIndex = (int) ((Math.random() * (max - min)) + min);
        var cartaSeleccionada =  Deck.get(randomIndex);
        Deck.remove(randomIndex);

        return cartaSeleccionada;
    }
}
