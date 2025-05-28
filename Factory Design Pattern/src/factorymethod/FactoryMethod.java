package factorymethod;

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

interface BurgerFactory {
    Burger createBurger(String type);
}

class SinghBurgerFactory implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        }

        System.out.println("Invalid burger type!");
        return null;
    }
}
class KingBurgerFactory implements BurgerFactory {
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
}


public class FactoryMethod {
    public static void main(String[] args) {
        BurgerFactory factory1 = new SinghBurgerFactory();
        Burger burger1 = factory1.createBurger("basic");

        if (burger1 != null) {
            burger1.prepare();
        }
    }
}
