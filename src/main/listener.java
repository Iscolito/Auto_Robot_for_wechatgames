package main;
import java.awt.*;
import java.awt.event.*;
/*重写监听库以便于自助选取目标范围*/
public class listener extends Frame implements MouseListener{
	int count;
	int[][] pos;
	int[] start;
	listener(int x, int y,int size){
		addMouseListener(this);	
		this.setUndecorated(true);
		setOpacity((float) 0.1);
		setLocation(x,y);
		setSize(size, size);
		setLayout(null);
		setVisible(true);
		count=0;
		int[] start = new int[] {x,y};
		pos = new int[2][2];
	}
	public void mouseClicked(MouseEvent e) {
		Graphics g=getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval(e.getX(), e.getY(), 10, 10);
		pos[count][0]=(int)e.getX();pos[count][1]=(int)e.getY();
		System.out.println(String.format("第%d个坐标为:", count+1));
		System.out.println(pos[count][0]);
		System.out.println(pos[count][1]);
		count++;
		if(count==2) {dispose();}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
