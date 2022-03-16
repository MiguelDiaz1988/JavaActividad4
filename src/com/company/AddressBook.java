package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contactos = new HashMap<>();
    private String  FILE_NAME = "src\\com\\company\\contactos.csv";

    public AddressBook() {
        this.load();
    }

    public void List() {
        for(Map.Entry<String, String> contacto : contactos.entrySet()) {
            System.out.println(contacto.getKey() + " : " + contacto.getValue());
        }
    }

    public void CrearContact(String numero, String nombre) {
        contactos.put(numero, nombre);
        this.save();
    }

    public void BorrarContacto(String numero) {
        contactos.remove(numero);
        this.save();
    }

    private void load() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                contactos.put(values[0], values[1]);
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    private void save() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME));
            for(Map.Entry<String, String> contacto : contactos.entrySet()) {
                bufferedWriter.write(contacto.getKey() + "," + contacto.getValue() + "\n");
            }

        } catch (Exception ex) {
            System.out.println("Error cuando se intento guardar los datos: " + ex.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception ex) {
                System.out.println("Error cuando se intento guardar los datos: " + ex.getMessage());
            }
        }
    }
}
