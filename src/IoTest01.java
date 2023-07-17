import java.io.File;

public class IoTest01 {
	public static void main(String[] args) {
		File filePath = new File("./src");
		
		String[] fileList = filePath.list();
		
		for(int i = 0;i<fileList.length;i++) {
			System.out.println(fileList[i]);
		}
		System.out.println("===========================");
		
		for(String x:fileList) {
			System.out.println(x);
		}
	}
}
