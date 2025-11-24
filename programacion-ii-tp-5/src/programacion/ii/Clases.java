class Titular {
    private String nombre;
    private Pasaporte pasaporte; // Referencia de vuelta (Asociación Bidireccional)

    public Titular(String nombre) {
        this.nombre = nombre;
    }

    // Setter para establecer la bidireccionalidad
    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }
}

// EJERCICIO 1: COMPOSICIÓN (Foto) y ASOCIACIÓN BIDIRECCIONAL (Titular)
class Foto {
    private String ilustracion;

    // Foto depende de Pasaporte para existir (se crea en su constructor)
    public Foto(String ilustracion) {
        this.ilustracion = ilustracion;
    }
}

class Pasaporte {
    private String numero;
    private Foto foto; // Relación de Composición (instanciada aquí)
    private Titular titular; // Relación de Asociación

    public Pasaporte(String numero, String ilustracionFoto, Titular titular) {
        this.numero = numero;
        // 1. COMPOSICIÓN: Instanciación de la parte dentro del todo
        this.foto = new Foto(ilustracionFoto); 
        // 2. ASOCIACIÓN BIDIRECCIONAL: Asignación de la referencia
        this.titular = titular;
        // 3. Establecer la bidireccionalidad en la otra clase
        titular.setPasaporte(this); 
    }
}

// EJERCICIO 2: AGREGACIÓN (Batería) y ASOCIACIÓN BIDIRECCIONAL (Usuario)
class Bateria {
    private int capacidadmAh;

    // Batería puede existir independientemente del Celular
    public Bateria(int capacidadmAh) {
        this.capacidadmAh = capacidadmAh;
    }
}

class Usuario {
    private String nombre;
    private Celular celular; // Referencia de vuelta (Asociación Bidireccional)

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
}

class Celular {
    private String modelo;
    private Bateria bateria; // Relación de Agregación
    private Usuario usuario; // Relación de Asociación

    public Celular(String modelo, Bateria bateria, Usuario usuario) {
        this.modelo = modelo;
        // 1. AGREGACIÓN: Se recibe el objeto preexistente por parámetro
        this.bateria = bateria; 
        // 2. ASOCIACIÓN BIDIRECCIONAL
        this.usuario = usuario;
        usuario.setCelular(this);
    }
}

// EJERCICIO 3: ASOCIACIÓN UNIDIRECCIONAL (Autor) y AGREGACIÓN (Editorial)
class Autor {
    private String nombre;
    public Autor(String nombre) { this.nombre = nombre; }
}

class Editorial {
    private String nombre;
    public Editorial(String nombre) { this.nombre = nombre; }
}

class Libro {
    private String titulo;
    private Autor autor; // Asociación Unidireccional (Libro -> Autor)
    private Editorial editorial; // Agregación

    public Libro(String titulo, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.autor = autor; // Se recibe la referencia de Autor
        this.editorial = editorial; // Se recibe la referencia de Editorial
    }
}

// EJERCICIO 4: ASOCIACIÓN BIDIRECCIONAL (Cliente) y AGREGACIÓN (Banco)
class Banco {
    private String nombre;
    public Banco(String nombre) { this.nombre = nombre; }
}

class Cliente {
    private String dni;
    private TarjetaDeCredito tarjeta; // Referencia de vuelta (Asociación Bidireccional)

    public Cliente(String dni) { this.dni = dni; }
    public void setTarjeta(TarjetaDeCredito tarjeta) { this.tarjeta = tarjeta; }
}

class TarjetaDeCredito {
    private String nroTarjeta;
    private Cliente cliente; // Asociación Bidireccional
    private Banco banco; // Agregación

    public TarjetaDeCredito(String nroTarjeta, Cliente cliente, Banco banco) {
        this.nroTarjeta = nroTarjeta;
        this.cliente = cliente;
        this.banco = banco; // Se recibe el Banco (que puede existir sin la Tarjeta)
        cliente.setTarjeta(this);
    }
}

// EJERCICIO 5: COMPOSICIÓN (PlacaMadre) y ASOCIACIÓN BIDIRECCIONAL (Propietario)
class PlacaMadre {
    private String chipSet;
    public PlacaMadre(String chipSet) { this.chipSet = chipSet; }
}

class Propietario {
    private String nombre;
    private Computadora computadora;
    public Propietario(String nombre) { this.nombre = nombre; }
    public void setComputadora(Computadora computadora) { this.computadora = computadora; }
}

class Computadora {
    private String marca;
    private PlacaMadre placaMadre; // Composición
    private Propietario propietario; // Asociación Bidireccional

    public Computadora(String marca, String chipSet, Propietario propietario) {
        this.marca = marca;
        this.placaMadre = new PlacaMadre(chipSet); // COMPOSICIÓN
        this.propietario = propietario;
        propietario.setComputadora(this);
    }
}

// EJERCICIO 6: ASOCIACIÓN UNIDIRECCIONAL (Cliente) y AGREGACIÓN (Mesa)
class Mesa {
    private int capacidad;
    public Mesa(int capacidad) { this.capacidad = capacidad; }
}

class Reserva {
    private String codigo;
    private Cliente cliente; // Asociación Unidireccional (Reserva -> Cliente)
    private Mesa mesa; // Agregación

    public Reserva(String codigo, Cliente cliente, Mesa mesa) {
        this.codigo = codigo;
        this.cliente = cliente; // Se recibe la referencia de Cliente
        this.mesa = mesa; // Se recibe la referencia de Mesa
    }
}

// EJERCICIO 7: AGREGACIÓN (Motor) y ASOCIACIÓN BIDIRECCIONAL (Conductor)
class Motor {
    private int potenciaHP;
    public Motor(int potenciaHP) { this.potenciaHP = potenciaHP; }
}

class Conductor {
    private String licencia;
    private Vehiculo vehiculo;
    public Conductor(String licencia) { this.licencia = licencia; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}

class Vehiculo {
    private String patente;
    private Motor motor; // Agregación
    private Conductor conductor; // Asociación Bidireccional

    public Vehiculo(String patente, Motor motor, Conductor conductor) {
        this.patente = patente;
        this.motor = motor; // AGREGACIÓN
        this.conductor = conductor;
        conductor.setVehiculo(this);
    }
}

// EJERCICIO 8: COMPOSICIÓN (FirmaDigital) y AGREGACIÓN (Usuario)
class FirmaDigital {
    private String hash;
    private Usuario usuario; // Agregación

    public FirmaDigital(String hash, Usuario usuario) {
        this.hash = hash;
        this.usuario = usuario; // AGREGACIÓN
    }
}

class Documento {
    private String contenido;
    private FirmaDigital firma; // Composición

    public Documento(String contenido, String hashFirma, Usuario usuarioFirmante) {
        this.contenido = contenido;
        // COMPOSICIÓN (la firma no tiene sentido sin el documento)
        this.firma = new FirmaDigital(hashFirma, usuarioFirmante);
    }
}

// EJERCICIO 9: ASOCIACIÓN UNIDIRECCIONAL (Paciente y Profesional)
class Paciente {
    private String nombre;
    public Paciente(String nombre) { this.nombre = nombre; }
}

class Profesional {
    private String especialidad;
    public Profesional(String especialidad) { this.especialidad = especialidad; }
}

class CitaMedica {
    private String fecha;
    private Paciente paciente; // Asociación Unidireccional
    private Profesional profesional; // Asociación Unidireccional

    public CitaMedica(String fecha, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.paciente = paciente; // Referencia al paciente
        this.profesional = profesional; // Referencia al profesional
    }
}

// EJERCICIO 10: COMPOSICIÓN (ClaveSeguridad) y ASOCIACIÓN BIDIRECCIONAL (Titular)
class ClaveSeguridad {
    private String hash;
    public ClaveSeguridad(String hash) { this.hash = hash; }
}

class CuentaBancaria {
    private String nroCuenta;
    private ClaveSeguridad clave; // Composición
    private Titular titular; // Asociación Bidireccional

    public CuentaBancaria(String nroCuenta, String hashClave, Titular titular) {
        this.nroCuenta = nroCuenta;
        this.clave = new ClaveSeguridad(hashClave); // COMPOSICIÓN
        this.titular = titular;
        // Asumiendo que la clase Titular de este ejercicio es diferente del Ejercicio 1.
        // Si no fuera así, habría que adaptar la clase Titular original.
    }
}

// EJERCICIO 11: DEPENDENCIA DE USO (Canción como Parámetro)
class Cancion {
    private String titulo;
    private int duracionSeg;
    public Cancion(String titulo, int duracionSeg) { this.titulo = titulo; }
    public String getTitulo() { return titulo; }
}

class Reproductor {
    private String marca;

    public Reproductor(String marca) { this.marca = marca; }

    // DEPENDENCIA DE USO: La clase Cancion se usa como parámetro
    public void reproducir(Cancion cancion) { 
        System.out.println("Reproductor " + marca + " reproduciendo: " + cancion.getTitulo());
    }
}

// EJERCICIO 12: DEPENDENCIA DE USO (Impuesto como Parámetro)
class Impuesto {
    private double monto;
    public Impuesto(double monto) { this.monto = monto; }
    public double getMonto() { return monto; }
}

class Contribuyente {
    private String nombre;
    private String cuil;
    public Contribuyente(String nombre, String cuil) { this.nombre = nombre; }
}

class Calculadora {
    private Contribuyente contribuyente; // Asociación o Agregación (se requiere para el cálculo)
    public Calculadora(Contribuyente contribuyente) { this.contribuyente = contribuyente; }

    // DEPENDENCIA DE USO: La clase Impuesto se usa como parámetro
    public void calcular(Impuesto impuesto) { 
        double total = impuesto.getMonto() * 1.21; // Ejemplo de cálculo
        System.out.println("Cálculo para " + contribuyente.getNombre() + ": Total con IVA: " + total);
    }
}

// EJERCICIO 13: DEPENDENCIA DE CREACIÓN (CódigoQR creado en el método)
class CodigoQR {
    private String valor;
    private Usuario usuario; // Asociación Unidireccional (CódigoQR -> Usuario)

    // El constructor recibe el valor y el usuario que lo solicita
    public CodigoQR(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
}

class GeneradorQR {
    
    // DEPENDENCIA DE CREACIÓN: El método genera y devuelve una instancia de CodigoQR
    public CodigoQR generar(String valor, Usuario usuario) { 
        System.out.println("Generando QR para: " + usuario.getNombre());
        
        // DEPENDENCIA DE CREACIÓN: Se crea la instancia localmente
        CodigoQR nuevoQR = new CodigoQR(valor, usuario); 
        
        return nuevoQR;
    }
}

// EJERCICIO 14: DEPENDENCIA DE CREACIÓN (Render creado en el método)
class Proyecto {
    private String nombre;
    private int duracionMin;
    public Proyecto(String nombre, int duracionMin) { this.nombre = nombre; }
}

class Render {
    private String formato;
    private Proyecto proyecto; // Asociación Unidireccional (Render -> Proyecto)

    public Render(String formato, Proyecto proyecto) {
        this.formato = formato;
        this.proyecto = proyecto;
    }
    public String getFormato() { return formato; }
}

class EditorVideo {
    
    // DEPENDENCIA DE CREACIÓN: El método genera y devuelve una instancia de Render
    public Render exportar(String formato, Proyecto proyecto) { 
        System.out.println("Exportando proyecto: " + proyecto.nombre + " al formato: " + formato);
        
        // DEPENDENCIA DE CREACIÓN: Se crea la instancia localmente
        Render nuevoRender = new Render(formato, proyecto); 
        
        return nuevoRender;
    }
}