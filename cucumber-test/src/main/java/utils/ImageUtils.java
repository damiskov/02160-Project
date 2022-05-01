package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static Image scaledImage(String filepath, int x, int y) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(ImageUtils.class.getResourceAsStream(filepath));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return img.getScaledInstance(x, y, Image.SCALE_DEFAULT);
	}

}
