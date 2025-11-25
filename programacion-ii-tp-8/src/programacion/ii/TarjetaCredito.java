package programacion.ii;

public class TarjetaCredito implements Pago, PagoConDescuento {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagado con tarjeta: $" + monto);
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.90;
    }
}
