import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* 객체 직렬화 클래스 Customer.java를 활용해서 객체 단위로 기록하기 위한 소스 */

public class IoTest10 {
	public static void main(String[] args) {

		Customer cus=new Customer(10,"홍길동",23,173.6);
		
		try {
			System.out.println(cus.toString());
			FileOutputStream fos=new FileOutputStream("./src/result10.txt");
		    ObjectOutputStream oos=new ObjectOutputStream(fos);
		    oos.writeObject(cus);//객체 단위로 기록
		    
		    oos.close(); fos.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
