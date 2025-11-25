package programacion.ii;

public class Empleado {

    private int id; 
    private String nombre; 
    private String puesto; 
    private double salario; 
    
    private static int totalEmpleados = 0; 


    public Empleado(String nombre, String puesto) {
        totalEmpleados++; 
        this.id = totalEmpleados; 
        this.nombre = nombre;
        this.puesto = puesto; 
        this.salario = 30000.0; 
    }


    public Empleado(int id, String nombre, String puesto, double salario) {
        totalEmpleados++; 
        this.id = id; 
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }


    /**
     * Método Sobrecargado 1: Actualiza el salario por un porcentaje de aumento.
     * @param porcentaje Porcentaje de aumento (ej: 10.0 para 10%).
     */
    public void actualizarSalario(double porcentaje) { 
        if (porcentaje > 0) {
            this.salario *= (1 + porcentaje / 100);
        }
    }

    /**
     * Método Sobrecargado 2: Actualiza el salario por una cantidad fija a aumentar.
     * @param cantidadFija Cantidad fija en moneda local.
     */
    public void actualizarSalario(int cantidadFija) { 
        if (cantidadFija > 0) {
            this.salario += cantidadFija;
        }
    }
    
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }


    public static int mostrarTotalEmpleados() { 
        return totalEmpleados;
    }

    @Override
    public String toString() {
        return "Empleado [ID=" + id + ", Nombre='" + nombre + "', Puesto='" + puesto + "', Salario=" + String.format("%.2f", salario) + "]";
    }
}