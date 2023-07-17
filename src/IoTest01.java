import java.io.IOException;
import java.io.InputStream;

/* InputStream은 바이트 입력 스트림의 최상위 추상클래스이다. 
 */
public class IoTest01 {
	public static void main(String[] args) {

		int data = 0;
		
		System.out.print("문자 입력>>");
		try {
			InputStream myIn=System.in;
			/* System.in은 키보드 입력장치와 연결됨. 
			 */
			
			while((data = myIn.read()) != -1) {
				//한 바이트 씩 읽어들임,더 이상 읽을 값이 없다면 -1
				System.out.write((char)data);
			}
		}catch(IOException ie) {ie.printStackTrace();}
	}
}
