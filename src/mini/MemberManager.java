package mini;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemberManager {

	public static int memberNumber = 0;

	public void Join(String id, String pwd, String name, String adrr, String birthDate, String gender) { // 회원가입

		MemberDB memberDB = new MemberDB();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String signupDate = date.format(new Date());

		Member user = new Member(id, pwd, name, adrr, birthDate, gender, signupDate, " ", " ", 0);
		System.out.println(user.toString());

		memberDB.menberUpdate(user);
		memberDB.loadingDBMethod();
		System.out.println("저장 디비" + memberDB.getListDB());

	}
	
	

	public boolean idCheck(String id) { // 아이디체크

		boolean isTrue = true;
		for (int j = 0; j < MemberDB.listDB.size(); j++) {
			if (id.equals(MemberDB.listDB.get(j).getId())) {
				JOptionPane.showInternalMessageDialog(null, "동일한 아이디가 존재합니다.");
				isTrue = false;
				break;
			}

		}

		if (isTrue) {
			JOptionPane.showInternalMessageDialog(null, "사용 가능한 아이디입니다.");
		}
		return	isTrue;
	}
	
	public boolean blankCheck(String id , String pwd, String name,String adrr,String birthDate) {
		
		boolean isTrue = false;
		if (id.isBlank() || pwd.isBlank() || name.isBlank() || adrr.isBlank() || birthDate.isBlank() ) {
			
			if(id.isBlank()) {
				JOptionPane.showInternalMessageDialog(null, "아이디가 공란입니다. 입력후 회원가입해주세요.");
			}else if(pwd.isBlank()) {
				JOptionPane.showInternalMessageDialog(null, "비밀번호가 공란입니다. 입력후 회원가입해주세요.");
			}else if(name.isBlank()) {
				JOptionPane.showInternalMessageDialog(null, "이름이 공란입니다. 입력후 회원가입해주세요.");
			}else if(adrr.isBlank()) {
				JOptionPane.showInternalMessageDialog(null, "주소가 공란입니다. 입력후 회원가입해주세요.");
			}else {
				JOptionPane.showInternalMessageDialog(null, "생년월일이 공란입니다. 입력후 회원가입해주세요.");
			}
			
		}else {
			isTrue = true;
		}
		
		
		return isTrue;
	}

	public boolean pwdCheck(String pwd1, String pwd2 ) { // 비번체크

		boolean isTrue = true;
		if (!(pwd1.equals(pwd2))) {
			JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			isTrue = false;
		}
		return isTrue;

	}

	public boolean birthDateCheck(String BirthDate) { // 생년월일 체크

		boolean isTrue = true;
		for (int j = 0; j < BirthDate.length(); j++) {
			char ch = BirthDate.charAt(j);
			if (!((ch >= '0' && ch <= '9') && BirthDate.length() == 8)) {

				JOptionPane.showInternalMessageDialog(null, "생년월일을 잘못입력하셧습니다. ex)19920513");
				isTrue = false;
				break;
			}
		}

		return isTrue;

	}

	public boolean login(String id, String pwd) { // 로그인
		
//		System.out.println("로그인메소드 :" +  MemberDB.listDB);
//		System.out.println("로그인 사이즈 :" +  MemberDB.listDB.size());
//		System.out.println(id);
//		System.out.println(pwd);
		
		boolean login = false;
		boolean noJoin = false;
		boolean master = false;
		
		if (id.isBlank() || pwd.isBlank()) {
			JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 공란입니다. 확인 후 다시 로그인 해주세요.");
		}

		for (int i = 1; i < MemberDB.listDB.size() ; i++) {

			// ArrayList 에 저장한 회원정보에서 아이디 비교
//				0번 인덱스는 미리 가입해둔 마스터 계정 => 마스터 계정 로그인 화면 출력
//			System.out.println(i+"번째" + MemberDB.listDB.get(i).getId());
//			System.out.println(i+ "번째" + MemberDB.listDB.get(i).getPwd());

			if (id.equals(MemberDB.listDB.get(i).getId()) && pwd.equals(MemberDB.listDB.get(i).getPwd())) {
				MemberManager.memberNumber = i;         
				login = true;
				noJoin = true;
				break;
			}
			if (id.equals(MemberDB.listDB.get(i).getId()) && !pwd.equals(MemberDB.listDB.get(i).getPwd())) {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 확인해주세요.");
				noJoin = true;
				break;
			}

		}
			if(!noJoin) {
				JOptionPane.showMessageDialog(null, "아이디가 없습니다. 회원가입해주세요");
			}

		
		return login;
	}

	public boolean loginM(String id, String pwd) { // 로그인

		boolean master = false;

		if (id.isBlank() || pwd.isBlank()) {
			JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 공란입니다. 확인 후 다시 로그인 해주세요.");

		}

		// ArrayList 에 저장한 회원정보에서 아이디 비교
//				0번 인덱스는 미리 가입해둔 마스터 계정 => 마스터 계정 로그인 화면 출력

		// 0번 인덱스에 마스터 계정 생성
		if (id.equals(MemberDB.listDB.get(0).getId()) && pwd.equals(MemberDB.listDB.get(0).getPwd())) {
			JOptionPane.showInternalMessageDialog(null, "마스터 계정에서 로그인 되었습니다.");

			master = true;
			MemberManager.memberNumber = 0;

		}
		if (id.equals(MemberDB.listDB.get(0).getId()) && !pwd.equals(MemberDB.listDB.get(0).getPwd())) {
			JOptionPane.showInternalMessageDialog(null, "마스터 계정에서 비밀번호가 틀렸습니다.");

		}
		if (id.isBlank() || pwd.isBlank()) {
			JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 공란입니다. 확인 후 다시 로그인 해주세요.");

		}

		return master;

	}

	public void Info() {

//			infoFrame.setInfoNameT(MemberDB.listDB.get(MemberManager.memberNumber).getName()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getName());
//			infoFrame.setInfoBirthDateT(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate());
//			infoFrame.setInfoAdrrTMemberDB.(listDB.get(MemberManager.memberNumber).getAdrr()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getAdrr());
//			infoFrame.setInfoSignupDate(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate());

//			infoFrame.setInfoNameT("안녕하세요");
//			infoFrame.setInfoBirthDateT()

	}

	public void MemberDelete() { // 회원 탈퇴

		MemberDB memberDB = new MemberDB();

		MemberDB.listDB.remove(MemberManager.memberNumber);
		memberDB.informationChang();
		JOptionPane.showInternalMessageDialog(null, "탈퇴되었습니다. 다시오지마세요");

	}

	public boolean EditInfopwd(String id, String BirthDate) {// 비번 변경전 정보확인

		boolean isTrue = false;
		if (id.equals(MemberDB.listDB.get(MemberManager.memberNumber).getId())) {
			if (BirthDate.equals(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate())) {
				isTrue = true;
			} else {
				JOptionPane.showInternalMessageDialog(null, "생년월일이 틀렸습니다.");

			}

		} else {
			JOptionPane.showInternalMessageDialog(null, "아이디가 틀렸습니다.");

		}

		return isTrue;

	}

	public boolean changedPwd(String pwd1, String pwd2) { // 비번변경

		boolean isTrue = false;

		if (pwd1.equals(pwd2)) {

			MemberDB.listDB.get(MemberManager.memberNumber).setPwd(pwd1);
			MemberDB memberDB = new MemberDB();
			memberDB.informationChang();
			isTrue = true;

			JOptionPane.showInternalMessageDialog(null, "비밀번호가 변경되었습니다.");

		} else {
			JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");

		}

		return isTrue;

	}

	public boolean resvervation(int revPrice ,String revTime) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String revDate = date.format(new Date());
		MemberDB memberDB = new MemberDB();
		
		boolean isTrue = true;
		
		for(int i = 0 ; i < MemberDB.listDB.size() ; i++) {
			
			
			if(MemberDB.listDB.get(i).getRevTime().equals(revTime)){
				isTrue = false;
				System.out.println("예약있음");
			}
		}
			
			if(isTrue){
				System.out.println("예약없음");
				MemberDB.listDB.get(MemberManager.memberNumber).setRevDate(revDate);
				MemberDB.listDB.get(MemberManager.memberNumber).setRevTime(revTime);
				MemberDB.listDB.get(MemberManager.memberNumber).setPrice(revPrice * 1000);
				
				memberDB.informationChang();
//				System.out.println("변경되값 " + MemberDB.listDB.get(MemberManager.memberNumber));
				memberDB.loadingDBMethod();
//				System.out.println("변경후 로딩 :" + MemberDB.listDB.get(MemberManager.memberNumber));
				
			}
			
		
		return isTrue;

	}
	
	public void resvervationCancel() { //예약취소
		MemberDB memberDB = new MemberDB();
		
		MemberDB.listDB.get(MemberManager.memberNumber).setRevDate(" ");
		MemberDB.listDB.get(MemberManager.memberNumber).setRevTime(" ");
		MemberDB.listDB.get(MemberManager.memberNumber).setPrice(0);
		memberDB.informationChang();
		memberDB.loadingDBMethod();
	}
	
	

}
