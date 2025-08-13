import abstractionhhp.Car;
import abstractionhhp.SUV;
import abstractionhhp.Sedan;
import implementaion.DieselEngine;
import implementaion.ElectricEngine;
import implementaion.PetrolEngine;

public class Main {
    public static void main(String[] args) {

        Car suvWithPetrol = new SUV(new PetrolEngine());
        suvWithPetrol.drive();

        Car sedanWithElectric = new Sedan(new ElectricEngine());
        sedanWithElectric.drive();

        Car suvWithDiesel = new SUV(new DieselEngine());
        suvWithDiesel.drive();

    }
}