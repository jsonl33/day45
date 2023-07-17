import java.io.File;
import java.io.IOException;

/* java.io패키지의 File클래스 실습  
 */
public class IoTest05 {
	public static void main(String[] args) throws IOException {

		String path = "./src";
		File dir = new File(path);
		String[] fileNames = dir.list();
		
		for(String s:fileNames) {
			File f=new File(path+"/"+s);
			System.out.println("\n========================>\n");
			System.out.println("파일이름 :"+ f.getName());
			System.out.println("경로:"+f.getPath());
			System.out.println("부모경로:"+ f.getParent());
			System.out.println("절대경로:"+f.getAbsolutePath());
			System.out.println("디렉토리여부:"+f.isDirectory());
			System.out.println("파일여부:"+f.isFile());
			System.out.println("\n=========================>\n");
		}
	}
}
