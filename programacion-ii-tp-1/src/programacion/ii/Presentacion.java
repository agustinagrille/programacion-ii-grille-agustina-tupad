package programacion.ii;

import java.util.Scanner;

public class Presentacion {

    public static String ingreso(Scanner scanner) {
        // ¡NO crear ni cerrar otro Scanner acá!
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();  // lee línea completa

        System.out.print("Ingresa tu edad: ");
        int edad = Integer.parseInt(scanner.nextLine().trim()); // robusto y sin mix nextInt/nextLine

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);

        return "Un gusto " + nombre + "! :)";
    }
}
