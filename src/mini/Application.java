package mini;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		System.out.println(memberDB.getListDB());
//		 MemberDB.listDB.clear();

		

//		
//		 memberDB.informationChang();




		
		lf.initialize1();				

			}

}
