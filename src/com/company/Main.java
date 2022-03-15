package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	    var newDeck = new Deck();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.print("Ingresa la accion a realizar:");
                String action = reader.readLine();
                switch (action){
                    case "shuffle":
                        newDeck.Shuffle();
                        break;
                    case "head":
                        newDeck.Head();
                        break;
                    case "hand":
                        newDeck.Hand();
                        break;
                    case "pick":
                        newDeck.Pick();
                        break;
                    default:
                        System.out.println("Accion no válida");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
