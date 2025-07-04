public class Main {
    public static void main(String[] args) {

        Folder root = new Folder("root");
        root.add(new File(1, "file1.txt"));
        root.add(new File(1, "file2.txt"));

        Folder docs = new Folder("docs");
        docs.add(new File(1, "file3.txt"));
        docs.add(new File(1, "file4.txt"));
        root.add(docs);

        Folder images = new Folder("images");
        images.add(new File(1, "photo.jpg"));
        root.add(images);


//        docs.ls(0);
//        root.ls(0);

//        root.openAll(0);

        FileSystemItem cwd = root.cd("docs");

        if(cwd != null)
            cwd.ls(0);
        else
            System.out.println("\nCould not cd into docs\n");

        System.out.println(root.getSize());

    }
}