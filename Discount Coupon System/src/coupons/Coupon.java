package coupons;

import model.Cart;

public abstract class Coupon {

    private Coupon next;

    public Coupon(){
        next = null;
    }

    public Coupon getNext() {
        return next;
    }

    public void setNext(Coupon next) {
        this.next = next;
    }

    public void applyDiscount(Cart cart){

        if(isApplicable(cart))
        {
            double discount = getDiscount(cart);
            cart.applyDiscount(discount);
            System.out.println(name() + " applied: " + discount);

            if(!isCombinable(cart)) return;
        }

        if(next != null)
            next.applyDiscount(cart);
    }

    public abstract boolean isApplicable(Cart cart);
    public abstract boolean isCombinable(Cart cart);

    public abstract double getDiscount(Cart cart);
    public abstract String name();
}
