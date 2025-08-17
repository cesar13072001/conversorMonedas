package org.caz.util;

import java.io.*;

public class HistorialConversiones {

        private static final String ARCHIVO = "historial.txt";

        public void guardarConversion(String texto) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
                writer.write(texto);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error al guardar en el historial: " + e.getMessage());
            }
        }


    public void mostrarHistorial() {
        File file = new File(ARCHIVO);
        if (!file.exists()) {
            System.out.println("No hay historial disponible todavía.");
            return;
        }
        System.out.println(".........................................................................");
        System.out.println("======================== HISTORIAL DE CONVERSIONES ========================");
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el historial: " + e.getMessage());
        }
        System.out.println("========================================================================");
    }

}
