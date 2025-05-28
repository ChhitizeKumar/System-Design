public class MySingleton {

    private MySingleton()
    {
        System.out.println("Singleton object created");
    }

    private static final class InstanceHolder {
        private static final MySingleton instance = new MySingleton();
    }

    public static MySingleton getInstance()
    {
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        MySingleton s1 = MySingleton.getInstance();
        MySingleton s2 = MySingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
