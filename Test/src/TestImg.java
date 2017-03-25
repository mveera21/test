import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.validation.SchemaFactoryLoader;

public class TestImg {

	public static void main(String[] args) throws IOException {
		BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		img.createGraphics().drawImage(ImageIO.read(new File("/Users/maddy/Desktop/Veera B'day/SID_1169.JPG")).getScaledInstance(300, 300, Image.SCALE_SMOOTH),0,0,null);
		ImageIO.write(img, "jpg", new File("/Users/maddy/jee-neon/Liberty/usr/servers/defaultServer/dropins/images.war/test1/test.JPG"));
	}

}
