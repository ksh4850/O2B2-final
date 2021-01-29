package mini;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private Image img;
	
	public ImagePanel (Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		//이미지의 크기를 최대값으로
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		//화면 사이즈를 맞춤
		setLayout(null);
	
	}
	
	public void paintComponent(Graphics g) {//패널을 열었을떄 자동으로 이미지를 열어주는것  
		g.drawImage(img, 0, 0, null);
		//(이미지 변수 , x시작 , y시작 ,
		
	}

}
