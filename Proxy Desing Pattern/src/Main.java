public class Main {
    public static void main(String[] args) {

        IImage image = new ImageProxy("sample.jpg");

        image.display();
    }
}