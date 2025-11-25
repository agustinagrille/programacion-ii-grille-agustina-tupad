# TP 7 – Herencia y Polimorfismo en Java

Este trabajo práctico tiene como propósito aplicar los conceptos de herencia y polimorfismo en Java mediante el desarrollo de cuatro ejercicios integradores:

### 1. Vehículos y herencia básica

En este ejercicio se implementa una estructura simple que permite comprender la reutilización de atributos y métodos mediante herencia:

- La clase `Vehiculo` actúa como superclase, definiendo atributos comunes como `marca` y `modelo`, junto con un método general `mostrarInfo()`.
- La clase `Auto` hereda de `Vehiculo`, incorpora un atributo adicional (`cantidadPuertas`) y redefine el método `mostrarInfo()` para adaptar su comportamiento al tipo específico de vehículo.

---

### 2. Figuras geométricas y clases abstractas

Este ejercicio introduce el uso de clases y métodos abstractos en una jerarquía clara:

- La clase `FiguraGeometrica` se define como clase abstracta y declara el método `calcularArea()` como abstracto, estableciendo un contrato común para todas las figuras.
- Las clases `Circulo` y `Rectangulo` implementan el cálculo de área según sus características particulares.

---

### 3. Empleados y polimorfismo aplicado

Aquí se aborda el polimorfismo a través del cálculo de sueldos:

- La clase abstracta `Empleado` define el método `calcularSueldo()`.
- `EmpleadoPlanta` y `EmpleadoTemporal` desarrollan sus propios cálculos según el tipo de relación laboral.
- Se utiliza una colección de `Empleado` para almacenar diferentes tipos de empleados.
- El operador `instanceof` se aplica cuando es necesario identificar el tipo concreto de cada objeto.

---

### 4. Animales y sobrescritura de métodos

Finalmente, se desarrolla una jerarquía donde la sobrescritura de métodos permite distinguir comportamientos:

- La clase `Animal` define métodos generales como `hacerSonido()` y `describirAnimal()`.
- `Perro`, `Gato` y `Vaca` sobrescriben el método `hacerSonido()` mediante `@Override`.

---

## Conclusiones

A partir de este trabajo se pudieron comprobar en la práctica los conceptos trabajados en la teoría:

- **Herencia (`extends`)**

  Permite crear jerarquías de clases donde una subclase **reutiliza atributos y métodos** de una superclase.  
  Ejemplos claros son:
  - `Auto` hereda de `Vehiculo`.
  - `Circulo` y `Rectangulo` heredan de `Figura`.
  - `EmpleadoPlanta` y `EmpleadoTemporal` heredan de `Empleado`.
  - `Perro`, `Gato` y `Vaca` heredan de `Animal`.

- **Polimorfismo**

  A través de referencias del tipo de la superclase (`Figura`, `Empleado`, `Animal`) se pueden almacenar objetos de diferentes subclases e invocar métodos sobrescritos.  
  La **llamada dinámica** hace que se ejecute la versión correcta del método según el tipo real del objeto.

- **Uso de `super` en constructores**  
  Se utilizó `super(...)` para inicializar correctamente los atributos heredados desde la superclase, manteniendo la responsabilidad de inicialización en un único lugar.

- **Modificadores de acceso**  
  El uso de `private`, `protected` y `public` permitió:
  - Encapsular atributos.
  - Controlar qué miembros pueden ser reutilizados o visibles por las subclases.

- **Clases y métodos abstractos**  
  En el ejercicio de figuras se vio cómo una **clase abstracta** (`Figura`) define una interfaz común (`calcularArea()`) que **obliga** a las subclases a implementar su propio comportamiento.  
  Esto facilita el diseño de jerarquías lógicas y evita instanciar tipos "incompletos".

- **Upcasting, downcasting e `instanceof`**  
  Aunque en estos ejercicios se priorizó el uso de polimorfismo sin abusar de downcasting, la idea general es:
  - **Upcasting**: asignar una subclase a una referencia de la superclase (por ejemplo: `Empleado e = new EmpleadoPlanta(...)`).
  - **Downcasting**: convertir una referencia de superclase a una subclase específica, verificando antes con `instanceof` cuando sea necesario.
  - `instanceof` se utiliza para distinguir entre diferentes subtipos cuando el comportamiento depende del tipo concreto.

En resumen, este trabajo permitió aplicar los fundamentos de la programación orientada a objetos y comprender cómo estos conceptos contribuyen al desarrollo de software más ordenado, reutilizable y mantenible.
