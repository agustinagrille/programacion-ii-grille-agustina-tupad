package programacion.ii;

import java.util.Scanner;

public class ProgramacionIi {

public static void main(String[] args) {
        System.out.println("--- Sistema de Gestión de Empleados ---");


        Empleado emp1 = new Empleado("Juan Pérez", "Desarrollador Junior");
        
        Empleado emp2 = new Empleado(101, "María García", "Diseñadora UX", 55000.0);
        
        Empleado emp3 = new Empleado("Carlos López", "Gerente de Proyecto");
        
        System.out.println("\n--- Empleados Creados ---");
        System.out.println(emp1); // toString() se invoca automáticamente
        System.out.println(emp2);
        System.out.println(emp3);
        

        System.out.println("\n--- Aplicando Aumentos de Salario ---");
        
        emp1.actualizarSalario(5000);
        System.out.println("Salario de " + emp1.getNombre() + " (ID " + emp1.getId() + ") actualizado por $5000 fijos:");
        System.out.println(emp1);

        emp2.actualizarSalario(12.5); // 12.5% de aumento
        System.out.println("Salario de " + emp2.getNombre() + " (ID " + emp2.getId() + ") actualizado por 12.5%:");
        System.out.println(emp2);
        
        System.out.println("\n--- Conteo Global ---");
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}
