package simplefactory;

import java.util.Objects;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Basic Burger prepared");
    }
}
class StandardBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Standard Burger prepared");
    }
}
class PremiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Premium Burger prepared");
    }
}

class BurgerFactory {

    public static Burger createBurger(String type){

        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger();
        }

        System.out.println("Invalid burger type!");
        return null;
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
//        BurgerFactory burgerFactory = new BurgerFactory();

        Burger burger = BurgerFactory.createBurger("premium");

//        Objects.requireNonNull(burger).prepare();

        if (burger != null) {
            burger.prepare();
        }
    }
}
