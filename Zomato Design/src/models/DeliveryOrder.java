package models;

import strategies.PaymentStrategy;

import java.util.List;

public class DeliveryOrder extends Order{

    private String deliveryAddress;

    public DeliveryOrder(){
        this.deliveryAddress = "";
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String getType() {
        return "Delivery";
    }
}
