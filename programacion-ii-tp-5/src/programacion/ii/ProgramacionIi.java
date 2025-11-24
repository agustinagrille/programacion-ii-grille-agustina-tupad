package programacion.ii;

import java.util.Scanner;

public class ProgramacionIi {

public static void main(String[] args) {
        System.out.println("--- PRUEBAS TP 5: RELACIONES UML ---");

        // EJERCICIO 1: Composición (Foto) y Asociación Bidireccional (Titular)
        Titular titular1 = new Titular("Juan Perez");
        Pasaporte pasaporte1 = new Pasaporte("A456789", "JuanPerez_face.jpg", titular1);
        System.out.println("1. Pasaporte Creado (Composición y Asociación Bidireccional OK).");

        // EJERCICIO 2: Agregación (Batería) y Asociación Bidireccional (Usuario)
        Bateria bateria1 = new Bateria(4000);
        Usuario usuario1 = new Usuario("Maria Lopez");
        Celular celular1 = new Celular("Samsung S23", bateria1, usuario1);
        System.out.println("2. Celular Creado (Agregación y Asociación Bidireccional OK).");

        // EJERCICIO 11: Dependencia de Uso (Reproductor -> Cancion)
        Reproductor reproductor = new Reproductor("Sony Walkman");
        Cancion cancion1 = new Cancion("Song Title", 180);
        System.out.print("11. Dependencia de Uso: ");
        reproductor.reproducir(cancion1); // Cancion usada como parámetro

        // EJERCICIO 13: Dependencia de Creación (GeneradorQR -> CodigoQR)
        Usuario usuarioQR = new Usuario("GeneradorTest");
        GeneradorQR generador = new GeneradorQR();
        CodigoQR qrGenerado = generador.generar("url_de_prueba", usuarioQR); // CódigoQR creado dentro del método
        System.out.println("13. Dependencia de Creación: QR generado con valor: " + qrGenerado.valor);

        // EJERCICIO 14: Dependencia de Creación (EditorVideo -> Render)
        Proyecto proyecto1 = new Proyecto("Vacaciones 2024", 15);
        EditorVideo editor = new EditorVideo();
        Render renderFinal = editor.exportar("MP4", proyecto1); // Render creado dentro del método
        System.out.println("14. Dependencia de Creación: Exportado en formato: " + renderFinal.getFormato());
    }
