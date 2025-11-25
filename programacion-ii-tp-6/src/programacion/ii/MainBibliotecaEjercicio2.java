import java.util.List;

public class MainBibliotecaEjercicio2 {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        Autor a1 = new Autor("A1", "Borges", "Argentina");
        Autor a2 = new Autor("A2", "Cortázar", "Argentina");
        Autor a3 = new Autor("A3", "Ursula K. Le Guin", "EEUU");

        biblioteca.agregarLibro("ISBN1", "Ficciones", 1944, a1);
        biblioteca.agregarLibro("ISBN2", "Rayuela", 1963, a2);
        biblioteca.agregarLibro("ISBN3", "Ciudad de Ilusiones", 1967, a3);
        biblioteca.agregarLibro("ISBN4", "El Aleph", 1949, a1);
        biblioteca.agregarLibro("ISBN5", "Bestiario", 1951, a2);

        System.out.println("Listado de libros:");
        biblioteca.listarLibros();

        System.out.println("\nBuscar libro por ISBN:");
        System.out.println(biblioteca.buscarLibroPorIsbn("ISBN3"));

        System.out.println("\nLibros publicados en 1949:");
        List<Libro> filtrados = biblioteca.filtrarLibrosPorAnio(1949);
        filtrados.forEach(System.out::println);

        System.out.println("\nEliminar libro ISBN2:");
        biblioteca.eliminarLibro("ISBN2");
        biblioteca.listarLibros();

        System.out.println("\nCantidad total de libros: " + biblioteca.obtenerCantidadLibros());

        System.out.println("\nAutores disponibles:");
        biblioteca.mostrarAutoresDisponibles();
    }
}
