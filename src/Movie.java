public class Movie {
   private String title;
   private String image;
   private double rating;
   private static int total;

   public Movie(String title, String image, String rating) {
      this.title = title;
      this.image = image;
      this.rating = Double.parseDouble(rating);
      total++;
   }

   public void printMovie() {
      double roundedRating = Math.round(this.rating);

      System.out.println();
      System.out.print("Title: ");
      System.out.println("\u001b[1m" + this.title + "\u001b[m");
      System.out.print("Poster: ");
      System.out.println("\u001b[1m" + this.image + "\u001b[m");
      System.out.println("\u001b[97m\u001b[104m Rating: " + this.rating + " \u001b[m");
      for (int i = 0; i < roundedRating; i++) {
         System.out.print("\u2b50");
      }

      System.out.println();
      for (int i = 0; i < (image.length() + 10); i++){
         System.out.print("_");
      }
      System.out.println();
   }

   public static int getTotal() { return total; }

   public String getImage() {
      return image;
   }

   public double getRating() {
      return rating;
   }

   public String getTitle() {
      return title;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public void setRating(String rating) {
      this.rating = Double.parseDouble(rating);
   }

   public void setTitle(String title) {
      this.title = title;
   }
}
