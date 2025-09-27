package programacion.ii;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionTipos {

    public static void main(Scanner sc) {
        int a = leerEntero(sc, "Ingresa el primer entero: ");
        int b = leerEntero(sc, "Ingresa el segundo entero: ");

        try {
            int resEntero = a / b;
            System.out.println("a) Division (int): " + resEntero);
        } catch (ArithmeticException e) {
            System.out.println("a) Error: division por cero (int).");
        }

        if (b == 0) {
            System.out.println("b) Error: division por cero (double).");
        } else {
            double resDouble = (double) a / b; // conversión de tipos
            System.out.println("b) Division (double): " + resDouble);
        }
    }

    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Ingresa un numero entero.");
                sc.nextLine(); // limpio buffer
            }
        }
    }
}
