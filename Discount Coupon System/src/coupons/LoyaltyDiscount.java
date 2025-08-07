package coupons;

import model.Cart;
import strategy.DiscountStrategy;
import strategy.StrategyManager;
import strategy.StrategyType;

public class LoyaltyDiscount extends Coupon{

    private double percent;
    private DiscountStrategy strategy;

    public LoyaltyDiscount(double percent) {
        this.percent = percent;
        strategy = StrategyManager.getInstance().getStrategy(StrategyType.PERCENT, percent, 0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.isLoyaltyMember();
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
        return "Loyalty Discount " + (int)percent + "% off";
    }
}
