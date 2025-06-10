package strategies;

public class UpiPaymentStrategy implements PaymentStrategy{

    private String upiID;

    public UpiPaymentStrategy(String upiID) {
        this.upiID = upiID;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI (" + upiID + ")");
    }
}
