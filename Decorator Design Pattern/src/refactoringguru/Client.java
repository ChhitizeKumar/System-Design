package refactoringguru;

public class Client {

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nChhitize Kumar,100000\nSteven Jobs,912000";

        DataSource encoded = new CompressionDecorator(
                                        new EncryptionDecorator(
                                            new FileDataSource("out/OutputDemo.txt")));

        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
