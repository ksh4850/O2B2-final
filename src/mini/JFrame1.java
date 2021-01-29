package mini;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrame1 extends JFrame {
	
	/*
	 * 프레임을 생성하는 방법 1
	 * 다른클래스에서 호출하는 방식
	 */
	
	public JFrame1() {
		
		this.setBounds(100, 100, 1600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
		
		//나타난 프레임은 기본값으로 프레임 사이즈 조정이 활성화 된다. true 사용자 조정이됨 , false는 사이즈 고정
//		this.setResizable(true);
	}

}
