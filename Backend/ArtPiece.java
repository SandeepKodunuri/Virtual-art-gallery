public class ArtPiece {
    private int id;
    private String title;
    private String artist;
    private String image;
   public ArtPiece(int id, String title, String artist, String image) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.image = image;

    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getImage() { return image; }
}