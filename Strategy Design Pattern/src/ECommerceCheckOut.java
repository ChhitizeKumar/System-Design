interface PaymentStrategy {
    void pay(double amount);
}
interface ShippingStrategy {
    void ship(String item);
}

class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI.");
    }
}

class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Card.");
    }
}

class StandardShipping implements ShippingStrategy {

    @Override
    public void ship(String item) {
        System.out.println("Shipping " + item + " via Standard Shipping.");
    }
}

class ExpressShipping implements ShippingStrategy {

    @Override
    public void ship(String item) {
        System.out.println("Shipping " + item + " via Express Shipping.");
    }
}

class CheckoutContext {
    private PaymentStrategy paymentStrategy;
    private ShippingStrategy shippingStrategy;

    public CheckoutContext(PaymentStrategy paymentStrategy, ShippingStrategy shippingStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.shippingStrategy = shippingStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
    public void ship(String item) {
        shippingStrategy.ship(item);
    }
}

public class ECommerceCheckOut {
    public static void main(String[] args) {

        CheckoutContext checkoutContext = new CheckoutContext(new UpiPayment(), new ExpressShipping());

        checkoutContext.pay(1000);
        checkoutContext.ship("Shoes");
    }
}
