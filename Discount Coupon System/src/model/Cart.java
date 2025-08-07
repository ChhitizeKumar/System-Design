package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;
    private boolean loyaltyMember;
    private double originalTotal;
    private double currentTotal;
    private String paymentBank;

    public Cart() {
        items = new ArrayList<>();
        originalTotal = 0.0;
        currentTotal = 0.0;
        loyaltyMember = false;
        paymentBank = "";
    }



    public void addProduct(Product p, int quantity){

        CartItem cartItem = new CartItem(p, quantity);
        items.add(cartItem);
        originalTotal += cartItem.itemTotal();
        currentTotal += cartItem.itemTotal();
    }

    public void applyDiscount(double discountAmt){
        currentTotal -= discountAmt;
        if(currentTotal<0)
            currentTotal = 0;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public boolean isLoyaltyMember() {
        return loyaltyMember;
    }

    public void setLoyaltyMember(boolean loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }

    public double getOriginalTotal() {
        return originalTotal;
    }

    public void setOriginalTotal(double originalTotal) {
        this.originalTotal = originalTotal;
    }

    public double getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(double currentTotal) {
        this.currentTotal = currentTotal;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }
}
