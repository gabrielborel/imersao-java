import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

   public static void main(String[] args) throws Exception {
      String apiURL = "https://alura-filmes.herokuapp.com/conteudos";
      var httpClient = new MyHttpClient();
      String json = httpClient.getData(apiURL);

      var stickerFactory = new StickerFactory();
      ContentExtractor imdbContentExtractor = new IMDBContentExtractor();
      List<Content> contentList = imdbContentExtractor.extract(json);

      for (int i = 0; i < 4; i++) {
         Content content = contentList.get(i);
         String imageURL = content.getUrlImage();
         String title = content.getTitle();

         var inputStream = new URL(imageURL).openStream();
         String fileName = "src/assets/out/" + title + ".png";

         stickerFactory.generate(inputStream, fileName);
      }
   }

}
