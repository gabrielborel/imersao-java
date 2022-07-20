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
      URI apiURI = URI.create(apiURL);

      var httpClient = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(apiURI).GET().build();
      HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

      var parser = new JsonParser();
      List<Map<String, String>> movieList = parser.parse(response.body());

      var stickerFactory = new StickerFactory();
      for (Map<String, String> movie : movieList) {
         String imageURL = movie.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
         String title = movie.get("title");
         String rating = movie.get("imDbRating");
         var inputStream = new URL(imageURL).openStream();
         String fileName = "src/assets/out" + title + ".png";
         var newMovie = new Movie(title, imageURL, rating);
         newMovie.printMovie();

         stickerFactory.generate(inputStream, fileName);
      }
   }

}
