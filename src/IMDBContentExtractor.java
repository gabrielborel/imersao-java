import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor {

   public List<Content> extract(String json) {

      var parser = new JsonParser();
      List<Map<String, String>> attributesList = parser.parse(json);

      List<Content> contents = new ArrayList<>();
      for (Map<String, String> attributes : attributesList) {
         String title = attributes.get("title");
         String url = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");;
         contents.add(new Content(title, url));
      }

      return contents;

   }

}
