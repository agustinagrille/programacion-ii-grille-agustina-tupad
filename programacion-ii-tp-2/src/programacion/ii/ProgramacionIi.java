package programacion.ii;

import java.util.Scanner;

public class ProgramacionIi {
    private static final Scanner scanner = new Scanner(System.in);

    private static final double DESCUENTO_ESPECIAL = 0.10;

 public static void main(String[] args) {
        mostrarMenu();
    }

rivate static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("===== TP2 - Programación Estructurada =====");
            System.out.println(" 1. Año bisiesto");
            System.out.println(" 2. Mayor de tres números");
            System.out.println(" 3. Clasificación de edad");
            System.out.println(" 4. Descuento por categoría");
            System.out.println(" 5. Suma de números pares (while)");
            System.out.println(" 6. Contador de positivos, negativos y ceros (for)");
            System.out.println(" 7. Validación de nota (do-while)");
            System.out.println(" 8. Precio final (función)");
            System.out.println(" 9. Costo de envío y total (funciones)");
            System.out.println("10. Actualización de stock");
            System.out.println("11. Descuento especial (variable global)");
            System.out.println("12. Array de precios (for-each)");
            System.out.println("13. Array de precios recursivo");
            System.out.println(" 0. Salir");
            System.out.print("Elegí una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            System.out.println();

            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                case 10 -> ejercicio10();
                case 11 -> ejercicio11();
                case 12 -> ejercicio12();
                case 13 -> ejercicio13();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

            System.out.println();

        } while (opcion != 0);
    }

    private static void ejercicio1() {
        System.out.print("Ingrese un año: ");
        int anio = scanner.nextInt();

        boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);

        if (esBisiesto) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " no es bisiesto.");
        }
    }

    private static void ejercicio2() {
        System.out.print("Ingrese el primer número: ");
        int n1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int n2 = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int n3 = scanner.nextInt();

        int mayor = n1;
        if (n2 > mayor) mayor = n2;
        if (n3 > mayor) mayor = n3;

        System.out.println("El mayor es: " + mayor);
    }

    private static void ejercicio3() {
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }
    }

    private static void ejercicio4() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String categoria = scanner.nextLine().trim().toUpperCase();

        double porcentajeDescuento;
        switch (categoria) {
            case "A" -> porcentajeDescuento = 10.0;
            case "B" -> porcentajeDescuento = 15.0;
            case "C" -> porcentajeDescuento = 20.0;
            default -> {
                System.out.println("Categoría inválida.");
                return;
            }
        }

        double descuento = precio * (porcentajeDescuento / 100.0);
        double precioFinal = precio - descuento;

        System.out.println("Descuento aplicado: " + porcentajeDescuento + "%");
        System.out.println("Precio final: " + precioFinal);
    }

    private static void ejercicio5() {
        int numero;
        int sumaPares = 0;

        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            numero = scanner.nextInt();

            if (numero % 2 == 0 && numero != 0) {
                sumaPares += numero;
            }

        } while (numero != 0);

        System.out.println("La suma de los números pares es: " + sumaPares);
    }

    private static void ejercicio6() {
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int n = scanner.nextInt();

            if (n > 0) {
                positivos++;
            } else if (n < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }

    private static void ejercicio7() {
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = scanner.nextInt();

            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }

        } while (nota < 0 || nota > 10);

        System.out.println("Nota guardada correctamente.");
    }

    private static void ejercicio8() {
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();
        System.out.print("Ingrese el impuesto en porcentaje (Ej: 10 para 10%): ");
        double impuesto = scanner.nextDouble();
        System.out.print("Ingrese el descuento en porcentaje (Ej: 5 para 5%): ");
        double descuento = scanner.nextDouble();

        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);
        System.out.println("El precio final del producto es: " + precioFinal);
    }

    private static double calcularPrecioFinal(double precioBase,
                                             double impuestoPorc,
                                             double descuentoPorc) {
        double impuesto = precioBase * (impuestoPorc / 100.0);
        double descuento = precioBase * (descuentoPorc / 100.0);
        return precioBase + impuesto - descuento;
    }

    private static void ejercicio9() {
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine().trim();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        if (costoEnvio < 0) {
            System.out.println("Zona inválida.");
            return;
        }

        double total = calcularTotalCompra(precioProducto, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
    }

    private static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return 5.0 * peso;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return 10.0 * peso;
        } else {
            return -1; // indicador de error
        }
    }

    private static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    private static void ejercicio10() {
        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = scanner.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();

        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
    }

    private static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    private static void ejercicio11() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;

        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    private static void ejercicio12() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // Modificamos el tercer precio (índice 2)
        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }

    private static void ejercicio13() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        imprimirRecursivo(precios, 0);

        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        imprimirRecursivo(precios, 0);
    }

    private static void imprimirRecursivo(double[] array, int indice) {
        if (indice == array.length) {
            return;
        }
        System.out.println("Precio: $" + array[indice]);
        imprimirRecursivo(array, indice + 1);
    }
}
