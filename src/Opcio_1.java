import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Opcio_1 {
    public static int opcio_1() {
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
            System.out.println("Partida " + i);
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

        return intentos;
    }
}
