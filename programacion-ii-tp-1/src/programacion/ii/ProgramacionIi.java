package programacion.ii;

import java.util.Scanner;

public class ProgramacionIi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // único Scanner para toda la app
        System.out.println("INFO: Iniciando mi primer app para UTN - TUPAD...");
        HolaMundo.saludar();
        Variables.imprimir();
        System.out.println("Ahora es tu turno!");
        String presentacion = Presentacion.ingreso(sc); // <--paso por parametros  el Scanner
        System.out.println(presentacion);
        System.out.println("Desea ingresar a la calculadora? ingrese Unicamente Y o N");
        String validador =  sc.nextLine();
        if(validador.equalsIgnoreCase("Y")){
             // Inicio sección de calculadora
            Selector.calcular(sc); // <--paso por parametros  el Scanner
        } else if (validador.equalsIgnoreCase("N")){
            System.out.println("No se selecciono ingreso a la calculadora");
        } else {
            System.out.println("No se selecciono una letra correcta");
        }

        //Comienzo ejercicio 6:
        mostrarMensaje();
        //Comienzo ejercicio 8:
        DivisionTipos.main(sc);
        //Cierre de scanner al finalizar el programa.
        sc.close();
    }
        public static void mostrarMensaje() {
        System.out.println("Nombre: Juan Pérez\nEdad: 30 años\nDirección: \"Calle Falsa 123\"");
    }
    
    
}
