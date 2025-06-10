package strategies;

public class CardPaymentStrategy implements PaymentStrategy{
    private Integer cardNumber;

    public CardPaymentStrategy(Integer card) {
        this.cardNumber = card;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " Credit Card (" + cardNumber + ")");
    }
}
