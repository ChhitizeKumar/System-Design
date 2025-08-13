package abstractionhhp;

import implementaion.Engine;

public class Sedan extends Car{

    public Sedan(Engine engine){
        super(engine);
    }

    @Override
    public void drive() {

        System.out.println("[Sedan] In Drive mode");
        engine.start();
    }
}
