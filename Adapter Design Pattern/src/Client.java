public class Client {

    public void getReport(Report report, String data)
    {
        System.out.println("Processed JSON: "
                + report.getJsonData(data));
    }
}
