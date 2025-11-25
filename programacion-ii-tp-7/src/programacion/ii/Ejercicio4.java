public class Ejercicio4 {
    public static void main(String[] args) {

        Animal[] animales = {
            new Perro(),
            new Gato(),
            new Vaca()
        };

        for (Animal a : animales) {
            a.hacerSonido();
        }
    }
}
