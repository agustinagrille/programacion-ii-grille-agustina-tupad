public abstract class FiguraGeometrica {
    protected String nombre;

    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();
}
