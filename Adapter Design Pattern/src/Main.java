public class Main {
    public static void main(String[] args) {

        XMLDataProvider xmlDataProvider = new XMLDataProvider();

        Report report = new XMLtoJSONDataProviderAdaptor(xmlDataProvider);
        Client client = new Client();

        client.getReport(report, "chhitize:23");
    }
}