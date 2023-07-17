import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* java.io의 FileReader는 주어진 파일로 부터 문자 단위로 읽어들이기 위한 입력스트림이다. 
 */
public class IoTest09 {
	public static void main(String[] args) {

		String fileName;
		String buf;
		
		Reader myIn = new InputStreamReader(System.in);//업캐스팅 -> 읽어들인 바이트를 문자로 변환
		BufferedReader keyBr =new BufferedReader(myIn);//버퍼링 해서 한꺼번에 문자를 효율적으로 읽어들임.
		
		try {
			System.out.print("파일명입력:./src/IoTest09.java>>");
			fileName = keyBr.readLine();
			
			FileReader fr=new FileReader(fileName);
			BufferedReader fileBr=new BufferedReader(fr);
			
			while((buf = fileBr.readLine())!= null) {//더 이상 읽을 문자가 없다면  null
				System.out.println(buf);
			}//while
			fileBr.close(); fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
