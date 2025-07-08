public class ImageProxy implements IImage{
    private String fileName;
    private IImage image;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        image = null;
    }

    @Override
    public void display() {

        if(image == null){
            image = new RealImage(fileName);
        }
        image.display();
    }
}
