public class Main {
    public static void main(String[] args) {

        //cant create obj like this
//        Singleton s1 = new Singleton();

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}