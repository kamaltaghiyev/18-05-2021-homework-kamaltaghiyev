import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        File xmlFile = new File("sample.xml");
        byte[] b = Files.readAllBytes(xmlFile.toPath());
        String xml = new String(b);
        JSONObject obj = XML.toJSONObject(xml);
        System.out.println(obj);
        FileWriter file=null;
        try {

            file = new FileWriter("test.txt");
            file.write(obj.toString());


        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
