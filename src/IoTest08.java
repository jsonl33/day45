import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1.java.io패키지의 InputStreamReader는 바이트로 읽어들인 것을 문자로 변환한다.
 * 
 * 2.java.io의 BufferedReader는 읽어들인 문자를 임시 메모리에 버퍼링 한 다음 한줄 끝까지 한꺼번에 문자를 효율적으로
 * 읽어들인다.
 */
public class IoTest08 {
	public static void main(String[] args) {
      String fileName;
      InputStreamReader myIn=new InputStreamReader(System.in);
      BufferedReader keyBr=new BufferedReader(myIn);
      
      try {
    	  System.out.print("파일 이름 입력>>");
    	  fileName=keyBr.readLine();//한줄 끝까지 문자열로 읽어들임.
    	  System.out.println(fileName);
      }catch(IOException ie) {
    	  ie.printStackTrace();
      }finally {
    	  try {
    		  if(keyBr != null) keyBr.close();
    		  if(myIn != null) myIn.close();
    	  }catch(Exception e) {e.printStackTrace();}
      }
	}
}
