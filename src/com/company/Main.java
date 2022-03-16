package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	    var ab = new AddressBook();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("### Menu de acciones ###");
                System.out.println("list   -> mostrar contactos de la agenta");
                System.out.println("create -> crear un nuevo contacto");
                System.out.println("delete -> borrar un contacto");
                System.out.print("Escriba una accion a realizar: ");
                String action = reader.readLine();
                switch (action){
                    case "list":
                        ab.List();
                        break;
                    case "create":
                        System.out.print("Ingresa nombre del contacto a crear: ");
                        String nombre = reader.readLine();
                        System.out.print("Ingresa numero del contacto a crear: ");
                        String numero = reader.readLine();
                        ab.CrearContact(numero, nombre);
                        break;
                    case "delete":
                        System.out.print("Ingresa numero a borrar: ");
                        numero = reader.readLine();
                        ab.BorrarContacto(numero);
                        break;
                    default:
                        System.out.println("Accion no válida");
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}

