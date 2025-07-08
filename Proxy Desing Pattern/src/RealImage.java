public class RealImage implements IImage{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;

        //Heavy Operation ....
        System.out.println("[RealImage] Loading image from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("[RealImage] Displaying " + fileName);
    }
}
