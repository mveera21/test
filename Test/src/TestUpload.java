
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPart;
 
import javax.imageio.ImageIO;
import javax.ws.rs.core.MediaType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

 
public class TestUpload {
  public static void main(String[] args) throws Exception {
    final String BASE_URI = "http://localhost:9080/rest/";
 
    Client c = Client.create();
    WebResource service = c.resource(BASE_URI);
 
    ByteArrayOutputStream bas = new ByteArrayOutputStream();

    BufferedImage bi = ImageIO.read(new File("/Users/maddy/Desktop/Veera B'day/SID_1169.JPG"));
    ImageIO.write(bi, "jpg", bas);
    byte[] logo = bas.toByteArray();
   
 
    MultiPart multiPart = new MultiPart();
    multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
    // Construct a MultiPart with two body parts
    multiPart.
      bodyPart(new BodyPart(logo, MediaType.APPLICATION_OCTET_STREAM_TYPE));
    multiPart.
    bodyPart(new BodyPart(logo, MediaType.APPLICATION_OCTET_STREAM_TYPE));
 
    // POST the request
    ClientResponse response = service.path("/upload/files2").
      type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, multiPart);
    System.out.println("Response Status : " + response.getEntity(String.class));
  }
}