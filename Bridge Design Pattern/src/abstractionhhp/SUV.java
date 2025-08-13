package abstractionhhp;

import implementaion.Engine;

public class SUV extends Car {

    public SUV(Engine engine){
        super(engine);
    }

    @Override
    public void drive() {

        System.out.println("[SUV] In Drive mode");
        engine.start();
    }
}
