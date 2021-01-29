package mini;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOutputStream extends ObjectOutputStream {
	
	 public MyOutputStream(OutputStream out) throws IOException 
	 {  //원래 ObjectOutputStream
	  super(out);
	 }
	 
	 @Override
	 protected void writeStreamHeader() throws IOException
	 {
	  //헤더를 없애준다
	 }
	 
	 

}
