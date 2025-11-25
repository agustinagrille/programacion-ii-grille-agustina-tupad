package programacion.ii;

import java.util.Scanner;

public class ProgramacionIi {

 public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TP 8 – Interfaces y Excepciones ===");
            System.out.println("1. División segura");
            System.out.println("2. Conversión cadena → número");
            System.out.println("3. Lectura archivo");
            System.out.println("4. Excepción personalizada (edad)");
            System.out.println("5. Try-with-resources");
            System.out.println("6. Demo de E-commerce");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            int op = sc.nextInt();

            switch (op) {
                case 1: divisionSegura(); break;
                case 2: conversionCadenaNumero(); break;
                case 3: lecturaArchivo(); break;
                case 4: validarEdad(); break;
                case 5: lecturaTryWithResources(); break;
                case 6: demoEcommerce(); break;
                case 0: return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    public static void demoEcommerce() {
        Cliente c = new Cliente("Agustina");
        Pedido pedido = new Pedido(c);

        pedido.agregarProducto(new Producto("Taza", 1500));
        pedido.agregarProducto(new Producto("Plato", 1200));

        double total = pedido.calcularTotal();

        TarjetaCredito tc = new TarjetaCredito();
        double totalConDescuento = tc.aplicarDescuento(total);
        tc.procesarPago(totalConDescuento);

        pedido.cambiarEstado("Procesando");
        pedido.cambiarEstado("Enviado");
    }
}
