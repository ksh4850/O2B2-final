package mini;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class MemberDB {
	
	public static List<Member> listDB = new ArrayList<Member>();
	
	
	public static List<Member> getListDB() {
		return listDB;
	}

	public static void setListDB(List<Member> listDB) {
		MemberDB.listDB = listDB;
	}
//	Member user
	public void menberUpdate(Member user) {
		listDB.add(user);
//		Member user = new Member("bbb", "bbb", "박광복", "강남구", 28, '남', "2021-01-25");
		
		
		
		
//		Member[] array = listDB.toArray(new Member[listDB.size()]);
		
		 FileOutputStream fos = null;
	     ObjectOutputStream oos = null;
	     
	     try {
	         
	         if(new File("src/miniDB.txt").exists()) // 저장할 파일 위치 임닌다 마지막 텍스트 
	         {
	          
	          fos = new FileOutputStream("src/miniDB.txt", true);    
	          oos = new MyOutputStream(fos);
	         }else
	         {
	        
	          fos = new FileOutputStream("src/miniDB.txt", true);    
	          oos = new ObjectOutputStream(fos);
	         }
	      
	         oos.writeObject(user);
	         oos.flush();
	         

	      }catch (FileNotFoundException e) {
				
				e.printStackTrace();
	     }catch (Exception e) {
	         e.printStackTrace();
	      }finally{	// 때려죽어도 무조건 실행됨
				try {
				if(oos != null) {
					oos.close();
					} 
				if(fos != null) {
					fos.close();
					} 
				}catch (IOException e) {
					e.printStackTrace();
				}
		
			}
			
	}
	
	
	public void informationChang() {
		

		
		Member[] memberArray = listDB.toArray(new Member[listDB.size()]);
		
		for(int i = 0; i < memberArray.length; i++){
            System.out.println(memberArray[i]);
         }
		
		 FileOutputStream fos = null;
	     ObjectOutputStream oos = null;
	     
	     try {
	         
	         if(new File("src/miniDB.txt").exists()) // 저장할 파일 위치 임닌다 마지막 텍스트 
	         {
	          
	          fos = new FileOutputStream("src/miniDB.txt");    
	          oos = new ObjectOutputStream(fos);
	         }else
	         {
	        
	          fos = new FileOutputStream("src/miniDB.txt");    
	          oos = new ObjectOutputStream(fos);
	         }
	      
	         for(int i = 0; i < memberArray.length; i++){
		            oos.writeObject(memberArray[i]);
		         }
	         
	         
	         oos.flush();
	         

	     }catch (FileNotFoundException e) {
				
				e.printStackTrace();
	     }catch (Exception e) {
		         e.printStackTrace();
		 }finally{	// 때려죽어도 무조건 실행됨
				try {
				if(oos != null) {
					oos.close();
					} 
				if(fos != null) {
					fos.close();
					} 
				}catch (IOException e) {
					e.printStackTrace();
				}
		
			}
			
	}
	
	
	
	
	
//	ArrayList<Member>
	public void loadingDBMethod() {
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		FileInputStream fis =  null;
		ObjectInputStream ois = null;
		Object ojt = null;
		
		
		try {
			fis = new FileInputStream(new File("src/miniDB.txt")); 
			ois = new ObjectInputStream(fis);
			ojt = ois;
			
			while((ojt = ois.readObject()) != null){
//				System.out.println((Member) ojt);
				list.add((Member) ojt) ;
			}
			
		
			
			
			
		}catch (EOFException e){ // 반본문 쓸떄 오류방지
	         System.out.println("파일을 다 읽었습니다.");
	    }catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{	
			try {
			if(ois != null) {
				ois.close();
				} 
			if(fis != null) {
				fis.close();
				} 
			}catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		MemberDB.setListDB(list);
		System.out.println(list);

	}
	
	
	
	
	
	
	
	
	
	

}
