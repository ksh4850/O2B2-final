package mini;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class ResvervationFrame  {

	

	private String revTime ;
	private int revPrice;
	private JLabel rvePriceL = new JLabel();

	
	
	public static void main(String[] args) {
//		ResvervationFrame jf = new ResvervationFrame();
//		MemberDB memberDB = new MemberDB();
//		memberDB.loadingDBMethod();
//		System.out.println(memberDB.getListDB());
//	
//		jf.initialize6();
//		jf.initialize9();

		
	}
	

	public void initialize6() {
		
		JFrame1 rveframe = new JFrame1();
		ImagePanel panel6 = new ImagePanel(new ImageIcon("src/images/61.jpg").getImage());
		rveframe.add(panel6);
		rveframe.pack();
		
		JLabel revMemberL = new JLabel( MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		revMemberL.setFont(new Font("굴림", Font.BOLD, 20));
		revMemberL.setBounds(1272, 40, 224, 32);
		panel6.add(revMemberL);
		
		rvePriceL = new JLabel();
		rvePriceL.setFont(new Font("굴림", Font.BOLD, 20));
		rvePriceL.setBounds(1406, 662, 119, 32);
		panel6.add(rvePriceL);
		
		
		//============================미용가격 체크 박스 버튼 ========================
		JCheckBox[] revPriceCk = new JCheckBox[7]; 
		
		for(int i = 0 ; i < 7 ; i++) {
			revPriceCk[i] = new JCheckBox("");
			panel6.add(revPriceCk[i]);
		}
		revPriceCk[0].setBounds(1231, 213, 21, 23);
		revPriceCk[1].setBounds(1231, 261, 21, 23);
		revPriceCk[2].setBounds(1232, 305, 21, 23);
		revPriceCk[3].setBounds(1231, 360, 21, 23);
		revPriceCk[4].setBounds(1232, 409, 21, 23);
		revPriceCk[5].setBounds(1232, 459, 21, 23);
		revPriceCk[6].setBounds(1232, 506, 21, 23);
		
		int[] price = {10 , 30, 25, 110, 110, 70, 130};		
		
		for(int i = 0 ; i < revPriceCk.length ; i++) {
			
		revPriceCk[i].addItemListener(new ItemListener() {	
			
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int sum  = 0;
				for(int i = 0 ; i < revPriceCk.length ; i++) {
						
					if(revPriceCk[i].isSelected()) {
						sum += price[i];
					}
				}
				
//				System.out.println(sum);
				rvePriceL.setText(sum + ",000원");
				revPrice = sum;
			}
				
			});
		}
		
		//============================예약시간 라디오 버튼 ==============================
		ButtonGroup group = new ButtonGroup();
		JRadioButton[] rveTimebtn = new JRadioButton[6];
		
		for(int i = 0 ; i < rveTimebtn.length ; i++) {
			rveTimebtn[i] = new JRadioButton("");
			group.add(rveTimebtn[i]);
			panel6.add(rveTimebtn[i]);
			
		}
		
		rveTimebtn[0].setBounds(387, 707, 22, 23);
		rveTimebtn[1].setBounds(611, 707, 22, 23);
		rveTimebtn[2].setBounds(840, 707, 22, 23);
		rveTimebtn[3].setBounds(387, 781, 22, 23);
		rveTimebtn[4].setBounds(611, 781, 22, 23);
		rveTimebtn[5].setBounds(840, 781, 22, 23);
		

		for(int i = 0 ; i < rveTimebtn.length ; i++) {
			
		rveTimebtn[i].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(rveTimebtn[0].isSelected()) {
					rveTimebtn[0].setActionCommand("10시"); 
					
				}else if(rveTimebtn[1].isSelected()) {
					rveTimebtn[1].setActionCommand("11시");
					
				}else if(rveTimebtn[2].isSelected()) {
					rveTimebtn[2].setActionCommand("12시");
					
				}else if(rveTimebtn[3].isSelected()) {
					rveTimebtn[3].setActionCommand("2시");
					
				}else if(rveTimebtn[4].isSelected()) {
					rveTimebtn[4].setActionCommand("3시");
					
				}else if(rveTimebtn[5].isSelected()) {
					rveTimebtn[5].setActionCommand("4시");
				}
					
				revTime = group.getSelection().getActionCommand();
//				System.out.println(revTime);
				boolean isTrue = false;
				for(int i = 0 ; i < MemberDB.listDB.size() ; i++ ) {
					if(MemberDB.listDB.get(i).getRevTime().equals(revTime)) {
						isTrue = true;
					}
				}
				
				if(isTrue) {
					JOptionPane.showInternalMessageDialog(null, "이미 예약된시간입니다. 다른시간에 예약 부닥드립니다.");
				}else {
					JOptionPane.showInternalMessageDialog(null, "예약 가능한 시간입니다.");
				}
			}
		});
		
		}
//		System.out.println(revTime);
		

		//==================================홈 버튼==============================
		
		JButton revHomeBtn = new JButton();
		revHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		revHomeBtn.setBounds(1193, 30, 49, 42);
		panel6.add(revHomeBtn);
		revHomeBtn.addActionListener(new ActionListener() {  //홈버튼
			public void actionPerformed(ActionEvent e) {
				
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.initialize2();
				rveframe.setVisible(false);
				
				
			}
		});
		
		//==================================예약하기 버튼=========================== 
		
		JButton revResvervationBtn = new JButton();
		revResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.jpg"));
		revResvervationBtn.setBounds(1272, 802, 252, 49);
		panel6.add(revResvervationBtn);
		revResvervationBtn.addActionListener(new ActionListener() {  //예약하기 버튼
			public void actionPerformed(ActionEvent e) {
				System.out.println(revPrice);
				System.out.println(revTime);
//				System.out.println(rvePriceL.getText());
				
				MemberManager membermanager = new MemberManager();
				
				initialize9(membermanager.resvervation(revPrice ,revTime));
				rveframe.setVisible(false);
				revPrice = 0;
				
			}
		});
		

	}
	
	
	
	
	
	
	public void initialize9(boolean is) {
		JFrame1 frame = new JFrame1();
		JoinFrame joinframe = new JoinFrame();
		
//		boolean is = false;
		if(is) {
			ImagePanel panel9 = new ImagePanel(new ImageIcon("src/images/9.jpg").getImage());
			frame.add(panel9);		
			frame.pack();
			
			
			JButton revnoBtn = new JButton("New button");
			revnoBtn.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
			revnoBtn.setBounds(898, 486, 177, 53);
			panel9.add(revnoBtn);
			revnoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					initialize6();
					
					
				}
			});
			
			
			JButton revyesBtn = new JButton("New button");
			revyesBtn.setIcon(new ImageIcon("src/buttonImages/예.png"));
			revyesBtn.setBounds(572, 486, 185, 53);
			panel9.add(revyesBtn);
			revyesBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.initialize2();
					
				}
			});
			
		}else {
			ImagePanel panel10 = new ImagePanel(new ImageIcon("src/images/10.jpg").getImage());
			frame.add(panel10);
			frame.pack();
			
			JButton rvenoBtn1 = new JButton("New button");
			rvenoBtn1.setIcon(new ImageIcon("src/buttonImages/예.png"));
			rvenoBtn1.setBounds(731, 484, 184, 49);
			panel10.add(rvenoBtn1);
			rvenoBtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					initialize6();
					
				}
			});
			
			
		}
		
		
		
	}

}
