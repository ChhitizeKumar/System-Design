package coupons;

import model.Cart;
import strategy.DiscountStrategy;
import strategy.StrategyManager;
import strategy.StrategyType;

public class BankCoupon extends Coupon{

    private String bank;
    private double minSpend;
    private double percent;
    private double offCap;
    private DiscountStrategy strat;

    public BankCoupon(String b, double ms, double percent, double offCap) {
        this.bank    = b;
        this.minSpend= ms;
        this.percent = percent;
        this.offCap  = offCap;
        this.strat   = StrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT_WITH_CAP, percent, offCap);
    }


    @Override
    public boolean isApplicable(Cart cart) {

        return cart.getOriginalTotal() >= minSpend &&
                cart.getPaymentBank().equals(bank);
    }

    @Override
    public boolean isCombinable(Cart cart) {
        return true;
    }

    @Override
    public double getDiscount(Cart cart) {

        return strat.calculate(cart.getOriginalTotal());

    }

    @Override
    public String name() {
        return bank + " Bank Rs " + (int)percent + " off upto " + (int)offCap;
    }
}
