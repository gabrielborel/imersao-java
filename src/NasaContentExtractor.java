import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

   public List<Content> extract(String json) {

      var parser = new JsonParser();
      List<Map<String, String>> attributesList = parser.parse(json);

      List<Content> contents = new ArrayList<>();
      for (Map<String, String> attributes : attributesList) {
         String title = attributes.get("title");
         String url = attributes.get("url");
         contents.add(new Content(title, url));
      }

      return contents;

   }

}
