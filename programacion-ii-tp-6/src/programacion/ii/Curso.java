public class Curso {

    private String codigo;
    private String nombre;
    private Profesor profesor; // bidireccional

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void setProfesor(Profesor profesor) {
        if (this.profesor == profesor) {
            return;
        }

        // quitar de profesor anterior
        if (this.profesor != null) {
            this.profesor.eliminarCurso(this);
        }

        this.profesor = profesor;

        if (profesor != null && !profesor.getCursos().contains(this)) {
            profesor.agregarCurso(this);
        }
    }

    public void mostrarInfo() {
        String nombreProf = (profesor != null) ? profesor.getNombre() : "SIN PROFESOR";
        System.out.println("Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + nombreProf +
                '}');
    }

    @Override
    public String toString() {
        String nombreProf = (profesor != null) ? profesor.getNombre() : "SIN PROFESOR";
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + nombreProf +
                '}';
    }

    // getters/setters

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
