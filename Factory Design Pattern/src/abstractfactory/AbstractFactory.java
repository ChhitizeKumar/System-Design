package abstractfactory;

interface Burger{
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic Burger prepared");
    }
}
class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Standard Burger prepared");
    }
}
class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premium Burger prepared");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("BasicWheatBurger prepared");
    }
}
class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("StandardWheatBurger prepared");
    }
}
class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("PremiumWheatBurger prepared");
    }
}

interface GarlicBread{
    public void prepare();
}

class BasicGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("BasicGarlicBread prepared");
    }
}
class CheeseGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("CheeseGarlicBread prepared");
    }
}

class BasicWheatGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("BasicWheatGarlicBread prepared");
    }
}
class ChesseWheatGarlicBread implements GarlicBread{
    @Override
    public void prepare() {
        System.out.println("ChesseWheatGarlicBread prepared");
    }
}

interface MealFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

class SinghMealFactory implements MealFactory {

    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }

    }
}

class KingMealFactory implements MealFactory {

    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new ChesseWheatGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        MealFactory factory = new KingMealFactory();

        Burger burger = factory.createBurger("premium");
        GarlicBread garlicBread = factory.createGarlicBread("cheese");

        if (burger != null) {
            burger.prepare();
        }

        if(garlicBread != null) {
            garlicBread.prepare();
        }
        
    }
}
