package strategy;

//Singleton
public class StrategyManager {

    private static final StrategyManager instance = new StrategyManager();

    private StrategyManager() {
    }

    public static StrategyManager getInstance(){
        return instance;
    }

    public DiscountStrategy getStrategy(StrategyType type, double param1, double param2){

        if(type == StrategyType.FLAT)
            return new FlatDiscountStrategy(param1);

        else if(type == StrategyType.PERCENT)
            return new PercentDiscountStrategy(param1);

        else if(type == StrategyType.PERCENT_WITH_CAP)
            return new PercentWithCapStrategy(param1, param2);

        return null;

    }
}
