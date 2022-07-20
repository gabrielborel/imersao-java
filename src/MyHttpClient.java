import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

   public String getData(String url) {
      try {
         URI apiURI = URI.create(url);

         var httpClient = java.net.http.HttpClient.newHttpClient();
         var request = HttpRequest.newBuilder(apiURI).GET().build();
         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

         return response.body();
      } catch(IOException | InterruptedException exception) {
         throw new RuntimeException(exception);
      }
   }

}
