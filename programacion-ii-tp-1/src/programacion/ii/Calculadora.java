/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.ii;

/**
 *
 * @author Agus
 */
public class Calculadora {
        // Método para sumar
    public static void suma(int a, int b) {
        System.out.println("La suma es: " + (a + b));
    }

    // Método para restar
    public static void resta(int a, int b) {
        System.out.println("La resta es: " + (a - b));
    }

    // Método para multiplicar
    public static void multiplicacion(int a, int b) {
        System.out.println("La multiplicación es: " + (a * b));
    }

       // División entera con try-catch (trunca decimales)
    public static void division(int a, int b) {
        try {
            int resultado = a / b; // puede lanzar ArithmeticException si b == 0
            System.out.println("La division es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero.");
        }
    }
}
