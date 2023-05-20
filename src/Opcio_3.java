import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Opcio_3 {
    // Método para mostrar la tabla de puntuaciones
    public static void mostrarPuntuaciones() {
        List<Puntuacio> puntuacions = new ArrayList<>();

        // Creamos un try-catch para leer el fichero de puntuaciones.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("puntuacions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String nom = parts[0];
                    int intents = Integer.parseInt(parts[1]);
                    puntuacions.add(new Puntuacio(nom, intents));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de puntuaciones");
            return;
        }

        // Ordenar la lista de puntuaciones por el número de intentos (de menor a mayor)
        Collections.sort(puntuacions, Comparator.comparingInt(Puntuacio::getIntents).reversed());

        // Mostrar la tabla de puntuaciones
        System.out.println("Tabla de puntuaciones:");
        for (int i = 0; i < puntuacions.size(); i++) {
            Puntuacio puntuacio = puntuacions.get(i);
            System.out.println((i + 1) + ". " + puntuacio.getNom() + ": " + puntuacio.getIntents() + " intents");
        }
    }

    // Clase Puntuacion para almacenar el nombre y número de intentos de cada jugador
    public static class Puntuacio {
        private String nom;
        private int intents;

        public Puntuacio(String nom, int intents) {
            this.nom = nom;
            this.intents = intents;
        }

        public String getNom() {
            return nom;
        }

        public int getIntents() {
            return intents;
        }
    }
}