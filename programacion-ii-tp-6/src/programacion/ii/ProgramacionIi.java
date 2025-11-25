package programacion.ii;

import java.util.List;
import java.util.Scanner;

public class ProgramacionIi {

    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        precargarProductos(inventario);

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Opción: ");
            String linea = sc.nextLine();
            try {
                opcion = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                opcion = -1;
            }

            switch (opcion) {
                case 1: // Crear productos y agregarlos
                    crearProductoDesdeConsola(inventario, sc);
                    break;
                case 2: // Listar todos los productos
                    inventario.listarProductos();
                    break;
                case 3: // Buscar por ID
                    System.out.print("Ingrese ID de producto: ");
                    String idBuscado = sc.nextLine();
                    Producto encontrado = inventario.buscarProductoPorId(idBuscado);
                    if (encontrado != null) {
                        System.out.println("Producto encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontró producto con ese ID.");
                    }
                    break;
                case 4: // Filtrar por categoría
                    CategoriaProducto cat = leerCategoria(sc);
                    List<Producto> porCat = inventario.filtrarPorCategoria(cat);
                    if (porCat.isEmpty()) {
                        System.out.println("No hay productos en la categoría: " + cat);
                    } else {
                        porCat.forEach(System.out::println);
                    }
                    break;
                case 5: // Eliminar por ID
                    System.out.print("Ingrese ID de producto a eliminar: ");
                    String idEliminar = sc.nextLine();
                    if (inventario.eliminarProducto(idEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("No se encontró producto con ese ID.");
                    }
                    break;
                case 6: // Actualizar stock
                    System.out.print("Ingrese ID de producto: ");
                    String idStock = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCant;
                    try {
                        nuevaCant = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad inválida.");
                        break;
                    }
                    if (inventario.actualizarStock(idStock, nuevaCant)) {
                        System.out.println("Stock actualizado.");
                    } else {
                        System.out.println("No se encontró producto con ese ID.");
                    }
                    break;
                case 7: // Total stock
                    System.out.println("Total de stock disponible: " + inventario.obtenerTotalStock());
                    break;
                case 8: // Producto con mayor stock
                    Producto max = inventario.obtenerProductoConMayorStock();
                    if (max != null) {
                        System.out.println("Producto con mayor stock: " + max);
                    } else {
                        System.out.println("No hay productos en el inventario.");
                    }
                    break;
                case 9: // Filtrar por rango de precio
                    try {
                        System.out.print("Precio mínimo: ");
                        double min = Double.parseDouble(sc.nextLine());
                        System.out.print("Precio máximo: ");
                        double maxPrecio = Double.parseDouble(sc.nextLine());
                        List<Producto> porPrecio = inventario.filtrarProductosPorPrecio(min, maxPrecio);
                        if (porPrecio.isEmpty()) {
                            System.out.println("No hay productos en ese rango de precio.");
                        } else {
                            porPrecio.forEach(System.out::println);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Valor de precio inválido.");
                    }
                    break;
                case 10: // Mostrar categorías
                    inventario.mostrarCategoriasDisponibles();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema de inventario...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ INVENTARIO =====");
        System.out.println("1) Crear y agregar nuevo producto");
        System.out.println("2) Listar todos los productos");
        System.out.println("3) Buscar producto por ID");
        System.out.println("4) Filtrar productos por categoría");
        System.out.println("5) Eliminar producto por ID");
        System.out.println("6) Actualizar stock de un producto");
        System.out.println("7) Mostrar total de stock");
        System.out.println("8) Mostrar producto con mayor stock");
        System.out.println("9) Filtrar productos por rango de precio");
        System.out.println("10) Mostrar categorías disponibles");
        System.out.println("0) Salir");
    }

    private static void precargarProductos(Inventario inventario) {
        inventario.agregarProducto(new Producto("P1", "Fideos", 800, 50, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("P2", "Celular", 150000, 10, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P3", "Remera", 5000, 25, CategoriaProducto.ROPA));
        inventario.agregarProducto(new Producto("P4", "Silla", 12000, 8, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("P5", "Auriculares", 7000, 15, CategoriaProducto.ELECTRONICA));
    }

    private static void crearProductoDesdeConsola(Inventario inventario, Scanner sc) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio;
        try {
            precio = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Precio inválido.");
            return;
        }
        System.out.print("Cantidad: ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
            return;
        }
        CategoriaProducto categoria = leerCategoria(sc);
        Producto p = new Producto(id, nombre, precio, cantidad, categoria);
        inventario.agregarProducto(p);
        System.out.println("Producto agregado.");
    }

    private static CategoriaProducto leerCategoria(Scanner sc) {
        System.out.println("Seleccione categoría:");
        CategoriaProducto[] valores = CategoriaProducto.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + ") " + valores[i] + " - " + valores[i].getDescripcion());
        }
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            opcion = 1;
        }
        if (opcion < 1 || opcion > valores.length) {
            opcion = 1;
        }
        return valores[opcion - 1];
    }
}
