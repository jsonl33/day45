import java.io.InputStream;
import java.io.OutputStream;

/* InputStream은 키보드 입력장치인 System.in과 연결되고, OutputStream은 모니터 출력장치인 System.out과
 * 연결된다.
 */
public class IoTest03 {
	public static void main(String[] args) {

		int data=0;
		InputStream myIn = System.in;
		OutputStream myOut = System.out;
		
		System.out.print("문자 입력>>");
		
		try {
			while((data = myIn.read()) != -1) {
				if(data == 'x' || data == 'X') {
					break;//반복문 중단
				}
				myOut.write((char)data);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}
