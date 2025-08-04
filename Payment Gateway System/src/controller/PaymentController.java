package controller;

import factory.GatewayFactory;
import factory.GatewayType;
import gateway.PaymentGateway;
import model.PaymentRequest;
import service.PaymentService;

//singleton
public class PaymentController {

    private static PaymentController instance = new PaymentController();
    private PaymentService paymentService;

    public PaymentController() {
        this.paymentService = PaymentService.getInstance();
    }

    public static PaymentController getInstance(){
        return instance;
    }

    public boolean handelPayment(GatewayType type, PaymentRequest request){

        PaymentGateway gateway = GatewayFactory.getInstance().getGateway(type);

        paymentService.setGateway(gateway);
        return paymentService.processPayment(request);

    }
}
