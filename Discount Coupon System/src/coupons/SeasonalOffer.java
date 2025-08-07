package coupons;

import model.Cart;
import model.CartItem;
import strategy.DiscountStrategy;
import strategy.StrategyManager;
import strategy.StrategyType;

public class SeasonalOffer extends Coupon{

    private double percent;
    private String category;
    private DiscountStrategy strategy;

    public SeasonalOffer(double percent, String category) {
        this.percent = percent;
        this.category = category;

        strategy = StrategyManager.getInstance().getStrategy(StrategyType.PERCENT, percent, 0);
    }

    @Override
    public boolean isApplicable(Cart cart) {

        for (CartItem item: cart.getItems())
        {
            if(item.getProduct().getCategory().equals(category))
                return true;
        }

        return false;
    }

    @Override
    public boolean isCombinable(Cart cart) {
        return true;
    }

    @Override
    public double getDiscount(Cart cart) {

        double totalAmt = 0;

        for (CartItem item: cart.getItems()){
            if(item.getProduct().getCategory().equals(category))
                totalAmt += item.itemTotal();
        }

        return strategy.calculate(totalAmt);
    }

    @Override
    public String name() {
        return "Seasonal Offer " + (int)percent + "% off " + category;
    }
}
