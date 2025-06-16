public class XMLtoJSONDataProviderAdaptor implements Report{

    private XMLDataProvider dataProvider;

    public XMLtoJSONDataProviderAdaptor(XMLDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public String getJsonData(String data) {

        // 1. Get XML from the adaptee
        String xml = dataProvider.getXMLData(data);

        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";

    }
}
