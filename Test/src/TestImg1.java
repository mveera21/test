import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class TestImg1 {

	public static void main(String[] args) {
		File stream = new File("/Users/maddy/Desktop/Veera B'day/SID_1169.JPG");

		String path = "/Users/maddy/Desktop/Veera B'day";
		String fileName = "test001.jpg";
		BufferedImage image = null;
		try {
			FileUtils.forceMkdir(new File(path+"/original"));
		 image= ImageIO.read(stream);
			ImageIO.write(image, "jpg", new File(path+"/original/" +fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileUtils.forceMkdir(new File(path+"/small"));
			BufferedImage img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
			//image= ImageIO.read(stream);
			img.createGraphics().drawImage(ImageIO.read(stream).getScaledInstance(64, 64, Image.SCALE_SMOOTH),0,0,null);
			//image.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
			//img.createGraphics().drawImage(image, 0,0,null);
			ImageIO.write(img, "jpg", new File(path+"/small/" +fileName));
			


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileUtils.forceMkdir(new File(path+"/medium"));
			BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

			//image= ImageIO.read(stream);
			img.createGraphics().drawImage(ImageIO.read(stream).getScaledInstance(300, 300, Image.SCALE_SMOOTH),0,0,null);
			ImageIO.write(img, "jpg", new File(path+"/medium/" +fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileUtils.forceMkdir(new File(path+"/large"));
			BufferedImage img = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			//image= ImageIO.read(stream);
			img.createGraphics().drawImage(ImageIO.read(stream).getScaledInstance(640, 640, Image.SCALE_SMOOTH),0,0,null);
			ImageIO.write(img, "jpg", new File(path+"/large/" +fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
