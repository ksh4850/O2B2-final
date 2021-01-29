package mini;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InfoFrame {
	
	private JTextField infoIdT;
	private JTextField infoBirthDateT;
	private JPasswordField infoPwdChT1;
	private JPasswordField infoPwdChT2;
	

	
	public InfoFrame() {
		
	}
	
	
	public static void main(String[] args) {
		InfoFrame fm = new InfoFrame();
		
		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		System.out.println(memberDB.getListDB());

		
		fm.initialize4();
//		fm.initialize5();
//		fm.initialize7();
//		fm.initialize8();
		
		
		
	}
	
	
	public void initialize4() { //개인정보 확인 
		
		JFrame1 infoframe = new JFrame1();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel4 = new ImagePanel(new ImageIcon("src/images/4.jpg").getImage());
		infoframe.add(panel4);		
		infoframe.pack();
		
		
		JLabel infoNameL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
		infoNameL.setFont(new Font("굴림", Font.BOLD, 28));
		infoNameL.setBounds(491, 160, 310, 50);
		panel4.add(infoNameL);
		
		
		JLabel infoBirthDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate());
		infoBirthDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoBirthDateL.setBounds(491, 280, 310, 50);
		panel4.add(infoBirthDateL);
		
		JLabel infoAdrrL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getAdrr());
		infoAdrrL.setFont(new Font("굴림", Font.BOLD, 28));
		infoAdrrL.setBounds(491, 397, 310, 50);
		panel4.add(infoAdrrL);
		
		JLabel infoJoinDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate());
		infoJoinDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoJoinDateL.setBounds(491, 517, 310, 50);
		panel4.add(infoJoinDateL);
		
		JLabel infoRevDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevDate());
		infoRevDateL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevDateL.setBounds(491, 640, 130, 50);
		panel4.add(infoRevDateL);
		
		JLabel infoRevTimeL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevTime());
		infoRevTimeL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevTimeL.setBounds(651, 640, 130, 50);
		panel4.add(infoRevTimeL);
		
		JLabel infoRevPriceL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getPrice()  + "원");
		infoRevPriceL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevPriceL.setBounds(811, 640, 130, 50);
		panel4.add(infoRevPriceL);
		

		JLabel infoMemberla = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");		//회원정보 라벨
		infoMemberla.setFont(new Font("굴림", Font.BOLD, 19));
		infoMemberla.setBounds(1356, 21, 214, 42);
		panel4.add(infoMemberla);
//		infoMemberla.setText(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		
	
		
		
		
		JButton infoHomeBtn = new JButton(); //홈버튼
		infoHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		infoHomeBtn.setBounds(1270, 20, 70, 54);
		panel4.add(infoHomeBtn);
		infoHomeBtn.addActionListener(new ActionListener() { //비번변경 전 정보확인창 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				infoframe.setVisible(false);
				LoginFrame loginframe = new LoginFrame(); 
				loginframe.initialize2();
			
			}
		});
		
		
		JButton infoLogout = new JButton();		//로그아웃 버튼
		infoLogout.setIcon(new ImageIcon("src/buttonImages/로그아웃.png"));
		infoLogout.setBounds(1388, 73, 156, 30);
		panel4.add(infoLogout);
		infoLogout.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				infoframe.setVisible(false);
				LoginFrame loginframe = new LoginFrame();
				loginframe.initialize1();
				
			}
		});
		
		
		JButton pwdchBtn = new JButton();		//pwd 변경버튼
		pwdchBtn.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경.png"));
		pwdchBtn.setBounds(492, 736, 192, 29);
		panel4.add(pwdchBtn);
		pwdchBtn.addActionListener(new ActionListener() { //비번변경 전 정보확인창 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				infoframe.setVisible(false);
				initialize7();
			}
		});
		
		
		JButton memberDelBtn = new JButton();	//회원탈퇴 버튼
		memberDelBtn.setIcon(new ImageIcon("src/buttonImages/회원탈퇴.png"));
		memberDelBtn.setBounds(913, 736, 129, 29);
		panel4.add(memberDelBtn);
		memberDelBtn.addActionListener(new ActionListener() { //회원탈퇴 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				infoframe.setVisible(false);
				initialize5();
			}
		});
		
		
		JButton cancelBookBtn = new JButton(""); //예약확인 버튼
		cancelBookBtn.setIcon(new ImageIcon("src/buttonImages/예약취소.png"));
		cancelBookBtn.setBounds(971, 632, 143, 59);
		panel4.add(cancelBookBtn);
		cancelBookBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				memberManager.resvervationCancel();
				infoRevDateL.setText(" ");
				infoRevTimeL.setText(" ");
				infoRevPriceL.setText(" ");
				
				
			}
		});

		
	}
	
	


	public void initialize5() {// 회원탈퇴
		JFrame1 infoframe = new JFrame1();

		ImagePanel panel5 = new ImagePanel(new ImageIcon("src/images/5.jpg").getImage());
		infoframe.add(panel5);
		infoframe.pack();
		
		JButton pwdYes = new JButton("");
		pwdYes.setIcon(new ImageIcon("src/buttonImages/예.png"));
		pwdYes.setBounds(530, 487, 211, 67);
		panel5.add(pwdYes);
		
		pwdYes.addActionListener(new ActionListener() {//회원 삭제 예 버튼
			public void actionPerformed(ActionEvent e) {
				MemberManager memberManager = new MemberManager();
				memberManager.MemberDelete();
				
				infoframe.setVisible(false);
				LoginFrame loginframe = new LoginFrame();
				loginframe.initialize1();
			}
		});
		
		
		JButton pwdNo = new JButton("");
		pwdNo.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
		pwdNo.setBounds(845, 487, 211, 67);
		panel5.add(pwdNo);
		
		pwdNo.addActionListener(new ActionListener() {//회원 삭제 아니요 버튼
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "발전하는 O2B2가 되겠습니다.");
				infoframe.setVisible(false);
				initialize4();
			}
		});
		
	}
	
	
	public void initialize7() {  // 비번호변경 전 정보확인
		JFrame1 infoframe = new JFrame1();
		ImagePanel panel7 = new ImagePanel(new ImageIcon("src/images/7.jpg").getImage());
		infoframe.add(panel7);	
		infoframe.pack();
		
		
		infoIdT = new JTextField();
		infoIdT.setBounds(617, 262, 369, 54);
		panel7.add(infoIdT);
		infoIdT.setColumns(20);
		
		
		infoBirthDateT = new JTextField();
		infoBirthDateT.setBounds(617, 422, 369, 59);
		panel7.add(infoBirthDateT);
		infoBirthDateT.setColumns(20);
		
		
		JButton infoCkBtn = new JButton("");
		infoCkBtn.setIcon(new ImageIcon("src/buttonImages/개인정보확인.png"));
		infoCkBtn.setBounds(599, 526, 380, 74);
		panel7.add(infoCkBtn);
		
		infoCkBtn.addActionListener(new ActionListener() { // 비번호변경으로 가는 버튼
			public void actionPerformed(ActionEvent e) {
				MemberManager memberManager = new MemberManager();
				
				if(memberManager.EditInfopwd(infoIdT.getText() , infoBirthDateT.getText())) {
					infoframe.setVisible(false);
					initialize8();
				}
					
				
				
			}
		});
		
		
		
		
	}
	
	
	public void initialize8() { // 비번변경 
		
		JFrame1 infoframe = new JFrame1();
		ImagePanel panel8 = new ImagePanel(new ImageIcon("src/images/8.jpg").getImage());
		infoframe.add(panel8);
		infoframe.pack();
		
		infoPwdChT1 = new JPasswordField();
		infoPwdChT1.setBounds(617, 262, 369, 54);
		panel8.add(infoPwdChT1);
		infoPwdChT1.setColumns(20);
		
		infoPwdChT2 = new JPasswordField();
		infoPwdChT2.setBounds(617, 401, 369, 54);
		panel8.add(infoPwdChT2);
		infoPwdChT2.setColumns(20);
		
		JButton pwdchbtn1 = new JButton(""); //비번 변경 버튼 
		pwdchbtn1.setIcon(new ImageIcon("src/buttonImages/비밀번호변경확인.jpg"));
		pwdchbtn1.setBounds(617, 533, 371, 62);
		panel8.add(pwdchbtn1);
		pwdchbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberManager memberManager = new MemberManager();
			
					if(memberManager.changedPwd(infoPwdChT1.getText(),infoPwdChT2.getText())) {
						infoframe.setVisible(false);
						initialize4();
					}
					
					
			}
		});
		
		
		
	}
	
	

		

}
	
	


