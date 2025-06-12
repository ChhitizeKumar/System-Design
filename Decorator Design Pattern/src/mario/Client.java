package mario;

public class Client {

    public static void main(String[] args) {
        Character mario = new Mario();
        System.out.println(mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println(mario.getAbilities());

        mario = new GunPower(mario);
        System.out.println(mario.getAbilities());


        mario = new StarPower(mario);
        System.out.println(mario.getAbilities());

    }
}
