# UML

<img width="1213" height="374" alt="image" src="https://github.com/user-attachments/assets/b91f34f0-15f4-44d7-8160-631cb0d70f96" />

Este diagrama resume todo el sistema de e-commerce, con sus relaciones, contratos y comportamientos definidos a través de interfaces.

### Para entender la imagen:
- Producto y Pedido implementan Pagable, cumpliendo el contrato calcularTotal().

- Pedido posee una relación de composición con Producto (lista de productos).

- Cliente implementa Notificable para recibir los cambios de estado del pedido.

- TarjetaCredito implementa dos interfaces → ejemplo claro de herencia múltiple por interfaz.

- EdadInvalidaException hereda de Exception, cumpliendo el pedido de crear una excepción personalizada.
