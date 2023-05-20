import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opcio_2 {
    public static void opcio_2() throws FileNotFoundException {

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

        //Bucle para recorrer y comparar las jugadas de cada uno
        int encerts = 0;
        for (int i = 0; i < jugadesCPU.size(); i++) {
            int jugadaCPU = jugadesCPU.get(i);
            int jugadaGamer = jugadesGamer.get(i);
            if (jugadaCPU == jugadaGamer) {
                encerts++;
            } else {
                break; // Si hay una jugada incorrecta, se sale del bucle
            }
        }

        //Repetimos bloque para escribir en fichero de puntuacions
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("puntuacions.txt", true));
            writer.write(nomGamer + " ");
            writer.write(encerts + "\n");
            writer.close();
            System.out.println("Dades guardades");
        } catch (IOException e) {
            System.out.println("Error durant el guardat");
        }
    }
}
