public class MainUniversidadEjercicio3 {

    public static void main(String[] args) {

        Universidad uni = new Universidad("UTN");

        Profesor p1 = new Profesor("P1", "Ana", "Matemática");
        Profesor p2 = new Profesor("P2", "Carlos", "Programación");
        Profesor p3 = new Profesor("P3", "Lucía", "Bases de Datos");

        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);

        Curso c1 = new Curso("C1", "Álgebra");
        Curso c2 = new Curso("C2", "Programación I");
        Curso c3 = new Curso("C3", "Programación II");
        Curso c4 = new Curso("C4", "BD I");
        Curso c5 = new Curso("C5", "Sistemas Operativos");

        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);

        uni.asignarProfesorACurso("C1", "P1");
        uni.asignarProfesorACurso("C2", "P2");
        uni.asignarProfesorACurso("C3", "P2");
        uni.asignarProfesorACurso("C4", "P3");

        System.out.println("\nListado de cursos:");
        uni.listarCursos();

        System.out.println("\nListado de profesores:");
        uni.listarProfesores();

        System.out.println("\nReporte cursos por profesor:");
        uni.reporteCantidadCursosPorProfesor();

        System.out.println("\nEliminar curso C3");
        uni.eliminarCurso("C3");
        uni.listarCursos();
        uni.reporteCantidadCursosPorProfesor();

        System.out.println("\nEliminar profesor P2");
        uni.eliminarProfesor("P2");
        uni.listarProfesores();
        uni.listarCursos();
        uni.reporteCantidadCursosPorProfesor();
    }
}
