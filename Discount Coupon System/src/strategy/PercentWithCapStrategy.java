package strategy;

public class PercentWithCapStrategy implements DiscountStrategy{

    private double percent;
    private double capAmt;

    public PercentWithCapStrategy(double capAmt, double percent) {
        this.capAmt = capAmt;
        this.percent = percent;
    }

    @Override
    public double calculate(double amount) {

        double percentAmt = (amount * percent) / 100;
        return Math.min(percentAmt, capAmt);
    }
}
