import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        //Bucle do-while creado para recorrer las 4 opciones del menú y la lógica de cada una
        do {
            mostrarMenu();
            System.out.print("Selecciona una opció: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //Escribimos nombre y guardamos en nomUsuari
                    System.out.println("Partida jugador vs CPU");
                    scanner.nextLine();
                    System.out.print("Introdueix el teu nom: ");
                    String nombreUsuario = scanner.nextLine();

                    //Bloque creado para escribir y guardar el nombre y los intentos en orden en el fichero
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("puntuacions.txt", true));
                        writer.write(nombreUsuario + " ");
                        int intentos = Opcio_1.opcio_1();
                        writer.write(intentos + "\n");
                        writer.close();
                        System.out.println("Dades guardades");
                    } catch (IOException e) {
                        System.out.println("Error durant el guardat");
                    }
                    break;
                case 2:
                    System.out.println("Partida fitxer_cpu vs fitxer_jugador");
                    Opcio_2.opcio_2();
                    break;
                case 3:
                    System.out.println("Mostrar taula de puntuacions");
                    Opcio_3.mostrarPuntuaciones();
                    break;
                case 4:
                    System.out.println("Sortir");
                    break;
                default:
                    System.out.println("Opció no vàlida. Selecciona una opció vàlida.");
                    break;
            }

            System.out.println();
            //Seleccionando 4 se hace un break al bucle
        } while (opcion != 4);

        scanner.close();
    }

    //Método para mostrar las opciones del menú
    public static void mostrarMenu() {
        System.out.println("1.- Partida jugador vs CPU");
        System.out.println("2.- Partida fitxer_cpu vs fitxer_jugador");
        System.out.println("3.- Mostrar taula de puntuacions");
        System.out.println("4.- Sortir");
    }

}