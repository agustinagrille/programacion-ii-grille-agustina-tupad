package programacion.ii;

public class PayPal implements Pago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago via PayPal: $" + monto);
    }
}
