public class EmpleadoTemporal extends Empleado {
    private int horas;
    private double valorHora;

    public EmpleadoTemporal(String nombre, int horas, double valorHora) {
        super(nombre);
        this.horas = horas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSueldo() {
        return horas * valorHora;
    }
}
