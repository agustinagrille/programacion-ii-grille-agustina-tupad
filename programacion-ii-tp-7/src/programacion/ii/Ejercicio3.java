import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", 300000));
        empleados.add(new EmpleadoTemporal("Luis", 100, 1500));

        for (Empleado e : empleados) {
            System.out.println(e.nombre + " → Sueldo: " + e.calcularSueldo());

            if (e instanceof EmpleadoPlanta) {
                System.out.println("Es empleado de planta");
            } else if (e instanceof EmpleadoTemporal) {
                System.out.println("Es empleado temporal");
            }
        }
    }
}
