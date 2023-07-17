import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* 객체 직렬화 클래스 Customer.java를 활용해서 result10.txt에 객체단위로 기록된 것을 객체 단위로 읽어온다. 
 */

public class IoTest11 {
	public static void main(String[] args) {

		try {
			FileInputStream fis=new FileInputStream("./src/result10.txt");
			//파일로 부터 바이트 단위로 읽어들이기 위한 fis생성
			ObjectInputStream ois=new ObjectInputStream(fis);
			Customer cus=(Customer)ois.readObject();//객체 단위로 읽어옴.
			
			System.out.println("ID \t name \t age \t height");//\t 탭키만큼 수평으로 띄움
			System.out.println("============================>");
			System.out.println(cus);//.toString()이 생략됨
		}catch(ClassNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
