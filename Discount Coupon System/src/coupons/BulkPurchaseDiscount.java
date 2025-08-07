package coupons;

import model.Cart;
import strategy.DiscountStrategy;
import strategy.StrategyManager;
import strategy.StrategyType;

public class BulkPurchaseDiscount extends Coupon{

    private double flatDiscountAmt;
    private double thresholdAmt;
    private DiscountStrategy strategy;

    public BulkPurchaseDiscount(double flatDiscountAmt, double thresholdAmt) {
        this.flatDiscountAmt = flatDiscountAmt;
        this.thresholdAmt = thresholdAmt;

        strategy = StrategyManager.getInstance().getStrategy(StrategyType.FLAT, flatDiscountAmt, 0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getOriginalTotal() >= thresholdAmt;
    }

    @Override
    public boolean isCombinable(Cart cart) {
        return true;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getOriginalTotal());
    }

    @Override
    public String name() {
        return "Bulk Purchase Rs " + (int)flatDiscountAmt + " off over " + (int)thresholdAmt;
    }
}
