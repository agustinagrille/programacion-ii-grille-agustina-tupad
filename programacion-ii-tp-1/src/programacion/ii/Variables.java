/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.ii;

/**
 *
 * @author agrille
 */
public class Variables {
    
            private static String name = "Agustina Grille"; //Los warnings que observamos acá son sugerencias del codigo: definir como final las variables o como constantes, 
            private static int edad = 26;                             // como la consigna no lo especifica, solo las definiré como estaticas y privadas para este caso de ejemplo
            private static double altura = 1.63;
            private static boolean estudiante = true;
    
    public static void imprimir(){
        System.out.println("Nombre de la alumna: " + name);
        System.out.println("Edad: " + edad + " | Altura: " + altura);
        System.out.println("Es estudiante?  " + estudiante);        
    }
    
}
