package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Motion {
	public static void main(String[] args) throws IOException {
		Auto_click a = new Auto_click();
		a.writeImageFile(a.CaptureScreen(0,0,3000));
	}
}
