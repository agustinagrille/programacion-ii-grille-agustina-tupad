public class Ejercicio2 {
    public static void main(String[] args) {
        FiguraGeometrica[] figuras = {
            new Circulo(5),
            new Rectangulo(3, 7)
        };

        for (FiguraGeometrica f : figuras) {
            System.out.println(f.nombre + " → Área: " + f.calcularArea());
        }
    }
}
