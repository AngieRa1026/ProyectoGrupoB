
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
            System.out.println("\nIngrese la informacion del estudiante " + (i + 1) + ":");

            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            System.out.print("Identificación: ");
            identificaciones[i] = scanner.nextLine();

            System.out.println("Ingrese las 3 notas del estudiante:");
            for (byte j = 0; j < 3; j++) {
                do {
                    System.out.print("Nota " + (j + 1) + " (0.0 a 5.0): ");
                    notas[i][j] = scanner.nextFloat();
                    if (notas[i][j] < 0.0 || notas[i][j] > 5.0) {
                        System.out.println("Por favor ingrese una nota valida.");
                    }
                } while (notas[i][j] < 0.0 || notas[i][j] > 5.0);
                scanner.nextLine();
            }
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

        System.out.println("======================================");
        System.out.println("       Reporte Final de Estudiantes   ");
        System.out.println("======================================");
        System.out.println("Nombre\tIdentificación\tPromedio\tEstado");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println(nombres[i] + "\t" + identificaciones[i] + "\t"
                    + promedios[i] + "\t" + estadoDeAprobacion[i]);

            if (estadoDeAprobacion[i].equals("Aprobado")) {
                System.out.println("¡Felicidades, " + nombres[i] + "! Sigue asi.");
            } else {
                System.out.println("Animo, " + nombres[i] + ". Esfuerzate mas para la proxima.");
            }

        }
        float mejorPromedio = 0f;
        int indiceMejorEstudiante = 0;

        for (byte i = 0; i < NUM_ESTUDIANTES; i++) {
            if (promedios[i] > mejorPromedio) {
                mejorPromedio = promedios[i];
                indiceMejorEstudiante = i;
            }
        }

        System.out.println("\nEl estudiante con el mejor promedio es:");
        System.out.println(nombres[indiceMejorEstudiante] + " (ID: " + identificaciones[indiceMejorEstudiante]
                + ") con un promedio de " + mejorPromedio);

        int numAprobados = 0, numReprobados = 0;
        float promedioGeneral = 0f;

        for (byte i = 0; i < NUM_ESTUDIANTES; i++) {
            promedioGeneral += promedios[i];
            if (estadoDeAprobacion[i].equals("Aprobado")) {
                numAprobados++;
            } else {
                numReprobados++;
            }
        }
        promedioGeneral /= NUM_ESTUDIANTES;

        System.out.println("\n--- Resumen Estadistico ---");
        System.out.println("Estudiantes aprobados: " + numAprobados);
        System.out.println("Estudiantes reprobados: " + numReprobados);
        System.out.printf("Promedio general: " + promedioGeneral);
    }
}
