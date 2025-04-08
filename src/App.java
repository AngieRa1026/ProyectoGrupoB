
import java.util.Scanner;

public class App {

    private static final float LIMITE_APROBACION = 3.0f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte NUM_ESTUDIANTES = 5;

        String[] nombres = new String[NUM_ESTUDIANTES];
        String[] identificaciones = new String[NUM_ESTUDIANTES];
        float[] promedios = new float[NUM_ESTUDIANTES];
        String[] estadoDeAprobacion = new String[NUM_ESTUDIANTES];

        float[][] notas = new float[NUM_ESTUDIANTES][3];

        System.out.println("Datos de los estudiantes");
        for (byte i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println("\nIngrese la información del estudiante " + (i + 1) + ":");

            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            System.out.print("Identificación: ");
            identificaciones[i] = scanner.nextLine();

            System.out.println("Ingrese las 3 notas del estudiante:");
            for (byte j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[i][j] = scanner.nextFloat();
            }
            scanner.nextLine();
        }

        for (byte i = 0; i < NUM_ESTUDIANTES; i++) {
            float sumaNotas = 0f;
            for (byte j = 0; j < 3; j++) {
                sumaNotas += notas[i][j];
            }
            promedios[i] = sumaNotas / 3.0f;

            if (promedios[i] >= LIMITE_APROBACION) {
                estadoDeAprobacion[i] = "Aprobado";
            } else {
                estadoDeAprobacion[i] = "Reprobado";
            }
        }

        System.out.println("\n Reporte final de estudiantes ");
        System.out.println("Nombre\tIdentificación\tPromedio\tEstado");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println(nombres[i] + "\t" + identificaciones[i] + "\t"
                    + promedios[i] + "\t" + estadoDeAprobacion[i]);
        }

        scanner.close();
    }
}
