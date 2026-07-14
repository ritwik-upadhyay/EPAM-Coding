public interface Payment {
    void processPayment();
}
abstract class AbstractPayment implements Payment {
}
class CreditCard extends AbstractPayment {
    @Override
    public void processPayment() {
        System.out.println("Payment processed using Credit Card.");
    }
}
class UPI extends AbstractPayment {
    @Override
    public void processPayment() {
        System.out.println("Payment processed using UPI.");
    }
}
class Wallet extends AbstractPayment {
    @Override
    public void processPayment() {
        System.out.println("Payment processed using Wallet.");
    }
}
class OnlinePaymentSystem {
    public static void main(String[] args) {
        Payment payment = new CreditCard();
        payment.processPayment();
        payment = new UPI();
        payment.processPayment();
        payment = new Wallet();
        payment.processPayment();
    }
}