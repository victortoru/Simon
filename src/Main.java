import java.io.*;
import java.util.ArrayList;
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
                    // Leer el contenido del fichero jugades_cpu.txt
                    List<Integer> jugadesCPU = new ArrayList<>();
                    Scanner scannerCPU = new Scanner(new File("jugades_cpu.txt"));
                    while (scannerCPU.hasNextLine()) {
                        int jugadaCPU = scannerCPU.nextInt();
                        jugadesCPU.add(jugadaCPU);
                    }
                    scannerCPU.close();

                    // Leer el contenido del fichero jugades_gamer
                    String nomGamer = "";
                    List<Integer> jugadesGamer = new ArrayList<>();
                    Scanner scannerGamer = new Scanner(new File("jugades_gamer.txt"));
                    // Leer el nombre del gamer
                    if (scannerGamer.hasNextLine()) {
                        nomGamer = scannerGamer.nextLine();
                    }
                    while (scannerGamer.hasNextLine()) {
                        int jugadaGamer = scannerGamer.nextInt();
                        jugadesGamer.add(jugadaGamer);
                    }
                    scannerGamer.close();
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

}