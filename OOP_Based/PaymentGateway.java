interface PaymentGateway {
    public abstract void processPayment();
}
class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Payment processed using Credit Card");
    }
}
class UPIPayment implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Payment processed using UPI");
    }
}
class Main {
    public static void main(String[] args) {
        PaymentGateway payment = new CreditCardPayment();
        payment.processPayment();
        payment = new UPIPayment();
        payment.processPayment();
    }
}