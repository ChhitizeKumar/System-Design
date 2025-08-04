package service;

import gateway.PaymentGateway;
import model.PaymentRequest;

//singleton
public class PaymentService {

    private static final PaymentService paymentService = new PaymentService();

    private PaymentGateway gateway;

    private PaymentService() {
        this.gateway = null;
    }

    public void setGateway(PaymentGateway gateway)
    {
        this.gateway = gateway;
    }

    public static PaymentService getInstance(){
        return paymentService;
    }

    public boolean processPayment(PaymentRequest request){

        if (gateway == null) {
            System.out.println("[PaymentService] No payment gateway selected.");
            return false;
        }

        return gateway.processPayment(request);

    }


}
