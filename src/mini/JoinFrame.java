package mini;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JoinFrame  {
	
	
	private JTextField joinIdField ;
	private JPasswordField joinPwdField;
	private JPasswordField joinPwd2Field;
	private JTextField joinNameField;
	private String joinGender;
	private JTextField joinBirthText;
	private JTextField joinAdrrText;
	
	
	public void initialize3() {
		
		
		JFrame1 joinframe = new JFrame1();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel3 = new ImagePanel(new ImageIcon("src/Images/3.jpg").getImage());
		joinframe.add(panel3);
		joinframe.pack();
		
		
		joinIdField = new JTextField();
		joinIdField.setBounds(403, 290, 257, 55);
		panel3.add(joinIdField);
		joinIdField.setColumns(10);
		
		
	
		
				
		joinPwdField = new JPasswordField();
		joinPwdField.setBounds(403, 442, 371, 59);
		panel3.add(joinPwdField);
		joinPwdField.setColumns(10);

		
		joinPwd2Field = new JPasswordField();
		joinPwd2Field.setBounds(403, 565, 371, 55);
		panel3.add(joinPwd2Field);
		joinPwd2Field.setColumns(10);

		
		joinNameField = new JTextField();
		joinNameField.setBounds(832, 290, 379, 59);
		panel3.add(joinNameField);
		joinNameField.setColumns(10);

		
		joinBirthText = new JTextField();
		joinBirthText.setBounds(832, 442, 379, 59);
		panel3.add(joinBirthText);
		joinBirthText.setColumns(10);

		
		joinAdrrText = new JTextField();
		joinAdrrText.setBounds(836, 565, 379, 55);
		panel3.add(joinAdrrText);
		joinAdrrText.setColumns(10);

		
		
		JRadioButton genWomBtn = new JRadioButton("여자");
		genWomBtn.setBounds(538, 768, 134, 38);
		panel3.add(genWomBtn);
		
		
		
		JRadioButton genManbtn = new JRadioButton("남자");
		genManbtn.setBounds(413, 768, 121, 38);
		panel3.add(genManbtn);
		
		
		
		ButtonGroup group = new ButtonGroup();
		
		
		
		group.add(genManbtn);
		group.add(genWomBtn);
		genManbtn.setSelected(true);
//		genWomBtn.setSelected(true);
		genManbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				genManbtn.setActionCommand("남자");
				 joinGender = group.getSelection().getActionCommand();
				System.out.println(joinGender);
			}
		});
		
		genWomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				genWomBtn.setActionCommand("여자");
				 joinGender = group.getSelection().getActionCommand();
				System.out.println(joinGender);
			}
		});
		
		
		JButton joinHomeBtn = new JButton("");	//홈버튼
		joinHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		joinHomeBtn.setBounds(1503, 27, 70, 54);
		panel3.add(joinHomeBtn);
		joinHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	
		
		JButton idCheck = new JButton("");		//중복확인버튼
		idCheck.setIcon(new ImageIcon("src/buttonImages/중복확인.jpg"));
		idCheck.setBounds(672, 290, 90, 59);
		panel3.add(idCheck);
		idCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				memberManager.idCheck(joinIdField.getText());
				
			}
		});
	
	
		JButton joinBtn = new JButton("");		//회원가입 버튼
		joinBtn.setIcon(new ImageIcon("src/buttonImages/회원가입.jpg"));
		joinBtn.setBounds(832, 727, 379, 68);
		panel3.add(joinBtn);
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if(memberManager.blankCheck(joinIdField.getText(), joinPwdField.getText(), joinNameField.getText(), joinAdrrText.getText(), joinBirthText.getText())
						&& memberManager.pwdCheck(joinPwdField.getText(),joinPwd2Field.getText()) 
						&& memberManager.birthDateCheck(joinBirthText.getText())) {
					
					memberManager.Join(joinIdField.getText(), joinPwdField.getText(), joinNameField.getText(), joinAdrrText.getText(), joinBirthText.getText(), joinGender);;
					joinframe.setVisible(false);
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.initialize1();
					
				}
			
			}
		});
		
	
	
	
	}
	

}
