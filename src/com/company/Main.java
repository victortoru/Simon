package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

                    //Bloque creado para escribir y guardar el nombre y los intentos en el fichero
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("puntuacions.txt", true));
                        writer.write(nombreUsuario + " ");
                        int intentos = Opcio_1();
                        writer.write(intentos + "\n");
                        writer.close();
                        System.out.println("Dades guardades");
                    } catch (IOException e) {
                        System.out.println("Error durant el guardat");
                    }
                    break;
                case 2:
                    System.out.println("Partida fitxer_cpu vs fitxer_jugador");
                    // Agrega aquí la lógica para la opción 2
                    break;
                case 3:
                    System.out.println("Mostrar taula de puntuacions");
                    // Agrega aquí la lógica para la opción 3
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

    public static int Opcio_1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsCPU = new ArrayList<>();
        List<Integer> numsJugador = new ArrayList<>();
        int intentos = 0;
        //Creamos el bucle para mostrar la secuencia de la CPU comparando con el JUGADOR
        for (int i = 1; i <= 10; i++) {
            System.out.print("CPU: ");
            for (int num : numsCPU) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.print("JUGADOR: ");
            for (int num : numsJugador) {
                System.out.print(num + " ");
            }
            System.out.println();
            //Creamos el numero random 1-4
            System.out.println("Partida " + i + ": Ha sortit");
            int numeroRandom = random.nextInt(4) + 1;
            numsCPU.add(numeroRandom);

            //Interfaz para que responda el jugador
            System.out.print("Escriu la resposta: ");
            int numUsuario = scanner.nextInt();
            numsJugador.add(numUsuario);
            intentos++;

            if (numsCPU.size() != numsJugador.size() || !numsCPU.equals(numsJugador)) {
                System.out.println("¡Has fallat!");
                break;
            }
        }

        System.out.println("¡Has encertat totes les rondes!");
        System.out.println("Nombre d'encerts: " + numsCPU.size());

        scanner.close();
        return intentos;
    }
}