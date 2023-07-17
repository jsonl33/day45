import java.io.FileInputStream;

/* java.io의 FilleInputStream 클래스를 활용해서 주어진 파일의 내용을 바이트 단위로 읽어들이는 입력스트림 */

public class IoTest06 {
	public static void main(String[] args) {

		int data= 0;
		String path = "./src/IoTest06.java";
		
		try {
			FileInputStream fis = new FileInputStream(path);
			
			while((data = fis.read()) != -1) {
				System.out.write((char)data);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}
