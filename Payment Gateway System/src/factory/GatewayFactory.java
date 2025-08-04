package factory;

import gateway.PaymentGateway;
import gateway.PaymentGatewayProxy;
import gateway.PaytmGateway;
import gateway.RazorpayGateway;

//singleton
public class GatewayFactory {

    private static final GatewayFactory instace = new GatewayFactory();

    private GatewayFactory(){}

    public static GatewayFactory getInstance(){
        return instace;
    }

    public PaymentGateway getGateway(GatewayType type){

        if(type == GatewayType.PAYTM)
        {
            PaymentGateway paymentGateway = new PaytmGateway();

            return new PaymentGatewayProxy(paymentGateway, 3);
        }

        PaymentGateway paymentGateway = new RazorpayGateway();

        return new PaymentGatewayProxy(paymentGateway, 2);
    }
}
