package programacion.ii;

import java.util.Scanner;

public class Selector {

    public static void calcular(Scanner scanner) {
        System.out.println("Inicio selector de Calculadora");

        boolean continuar = true;
        while (continuar) {
            int a = leerEntero(scanner, "Ingresa el primer numero: ");
            int b = leerEntero(scanner, "Ingresa el segundo numero: ");

            System.out.println("Selecciona una operacion: (Todas son con numeros enteros de momento)");
            System.out.println("1) Suma");
            System.out.println("2) Resta");
            System.out.println("3) Multiplicacion");
            System.out.println("4) Division");
            System.out.println("0) Salir");

            int opcion = leerEntero(scanner, "Opcion a elegir: ");

            switch (opcion) {
                case 1 -> Calculadora.suma(a, b);
                case 2 -> Calculadora.resta(a, b);
                case 3 -> Calculadora.multiplicacion(a, b);
                case 4 -> Calculadora.division(a, b);
                case 0 -> {
                    System.out.println("¡Programa Finalizado!");
                    continuar = false;
                }
                default -> System.out.println("Opcion no válida.");
            }
        }
    }

    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
            }
        }
    }
}
