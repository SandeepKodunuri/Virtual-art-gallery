import java.io.*;
import java.net.*;
import com.google.gson.Gson;
public class Main {
    public static void main(String[] args)throws Exception {
        ArtGallery gallery = new ArtGallery();
        Gson gson = new Gson();

        //Start Http server
        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while(true){
         Socket socket = serverSocket.accept();
         InputStreamReader reader = new InputStreamReader(socket.getInputStream());
         BufferedReader br = new BufferedReader(reader);
         String line;
         while ((line = br.readLine()) !=null) {
            if(line.startsWith("GET /artworks")){
                //Respond with JSON artwork data
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: application/json");
                out.println();
                out.println(gson.toJson(gallery.getArtworks()));
                out.flush();
            }
            
         }
         socket.close();
        }
    }
    
}
