import controller.PaymentController;
import factory.GatewayType;
import model.PaymentRequest;

//Client
public class Main {
    public static void main(String[] args) {
        PaymentRequest req1 = new PaymentRequest("Chhitize", "Shubham", 1000.0, "INR");

        System.out.println("Processing via Paytm");
        System.out.println("------------------------------");
        boolean res1 = PaymentController.getInstance().handelPayment(GatewayType.PAYTM, req1);
        System.out.println("Result: " + (res1 ? "SUCCESS" : "FAIL"));
        System.out.println("------------------------------\n");



        PaymentRequest req2 = new PaymentRequest("Shubham", "Chhitize", 500.0, "USD");

        System.out.println("Processing via Razorpay");
        System.out.println("------------------------------");
        boolean res2 = PaymentController.getInstance().handelPayment(GatewayType.RAZORPAY, req2);
        System.out.println("Result: " + (res2 ? "SUCCESS" : "FAIL"));
        System.out.println("------------------------------");
    }
}