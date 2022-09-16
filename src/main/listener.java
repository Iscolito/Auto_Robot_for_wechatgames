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
		setOpacity((float) 0.3);
		setLocation(x,y);
		setSize(size, size);
		setLayout(null);
		setVisible(true);
		count=0;
		int[] start = new int[] {x,y};
		pos = new int[4][2];
	}
	public void exit() {
		setVisible(false);
	}
	public void mouseClicked(MouseEvent e) {
		Graphics g=getGraphics();
		Font font1=new Font("宋体",Font.BOLD,20);
		g.setFont(font1);
		g.drawString(String.format("请选择您希望获得的区域的左上角的点和右下角的点，出现矩形后再次单击"),500,500);
		g.setColor(Color.BLACK);
		pos[count][0]=(int)e.getX();pos[count][1]=(int)e.getY();
		if(count==1||count==2) {g.fillOval(e.getX(), e.getY(), 10, 10);}
		System.out.println(String.format("第%d个坐标为:", count+1));
		System.out.println(pos[count][0]);
		System.out.println(pos[count][1]);
		count++;
		int left=Math.min(pos[1][0], pos[2][0]),top=Math.min(pos[1][1], pos[2][1]),
				right=Math.abs(pos[1][0]-pos[2][0]),bottom=Math.abs(pos[1][1]-pos[2][1]);
		if(count==3) {g.drawRect(left, top, right, bottom);}
		if(count==4) {g.dispose();}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
