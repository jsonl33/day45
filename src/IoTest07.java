import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* java.io패키지의 FileOutputStream 클래스는 주어진 파일에 바이트 단위로 기록하기 위한 클래스이다. 
 */
public class IoTest07 {
	public static void main(String[] args) {

		int data=0;
		System.out.print("저장할 내용 입력>>");
		
		try {
		    File f=new File("./src/result.txt");
		    FileOutputStream fos=new FileOutputStream(f);
		    //주어진 파일에 바이트 단위로 기록하기 위한 fos객체 생성
		    
		    while((data = System.in.read()) != -1) {
		    	if(data == 'x' || data == 'X') {
					break;//반복문 중단
				}
		    	fos.write((char)data);//파일에 기록한다.
		    }//while
		    fos.close();
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}		
	}
}
