package main;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Auto_click {
	/*robot对象使用无参函数构建时提示可能会出现抛出不支持低级输入控制的错误*/
	Robot robot;
	PointerInfo mouse;
	MouseEvent Mevent;
	/*构造器 选择鼠标所在处为目标屏幕*/
	Auto_click() {
		/*Mouseinfo必须get之后才能初始化或更新鼠标信息*/
		mouse=MouseInfo.getPointerInfo();
		try {robot=new Robot(mouse.getDevice());}
		catch(AWTException e) {e.printStackTrace();}
	}
	/*捕捉鼠标两次点击位置构成的矩形区域*/
	public BufferedImage CaptureScreen(int x, int y,int size) {	
		listener selecter = new listener(x,y,size);
		while(selecter.pos[1][1]==0) {robot.delay(10);}
		int width = Math.abs(selecter.pos[0][0]-selecter.pos[1][0]),height=Math.abs(selecter.pos[0][1]-selecter.pos[1][1]);
		return robot.createScreenCapture(new Rectangle(selecter.pos[0][0]+x,selecter.pos[0][1]+y,width,height));
	}
	/*输出截图到项目文件下*/
	public void writeImageFile(BufferedImage screenshot) throws IOException {
        File outputfile = new File("screenshot.png");
        ImageIO.write(screenshot, "png", outputfile);
    }
	/*移动到pos表示的的坐标并使用鼠标左键进行点击操作(同时会释放鼠标左键)*/
	public void Click(int[] pos) {
		robot.mouseMove(pos[0], pos[1]);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
