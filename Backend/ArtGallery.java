import java.util.ArrayList;
import java.util.List;

public class ArtGallery {
    private List<ArtPiece> artworkList;

    public ArtGallery() {
        artworkList = new ArrayList<>();
        artworkList.add(new ArtPiece(1, "Sunset", "Venkatesh", ""));
        artworkList.add(new ArtPiece(2, "Ocean Breeze", "Aadhi", ""));
        // More artworks can be added here
    }

    public List<ArtPiece> getArtworks() {
        return artworkList;
    }
}
