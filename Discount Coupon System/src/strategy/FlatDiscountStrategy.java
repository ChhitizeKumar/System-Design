package strategy;

public class FlatDiscountStrategy implements DiscountStrategy{

    private double flatOffAmt;

    public FlatDiscountStrategy(double flatOffAmt) {
        this.flatOffAmt = flatOffAmt;
    }

    @Override
    public double calculate(double amount) {

        return Math.min(flatOffAmt, amount);
    }
}
