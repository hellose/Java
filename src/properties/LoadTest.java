package properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadTest {

	public static void main(String[] args) {

		String fileName = "Sample.properties";

		InputStream is = null;
		try {

			// 1 ./ -> 현재 워킬디렉토리 GitJava
//			is = new BufferedInputStream(new FileInputStream("./src/properties/" + fileName));

			// 2 절대경로 루트
//			is = new BufferedInputStream(new FileInputStream("C:\\Users\\owner\\Desktop\\GitJavaWorkspace\\GitJava\\src\\properties\\" + fileName));

			// 3 / -> 절대경로 루트
//			is = new BufferedInputStream(new FileInputStream(
//					"\\Users\\owner\\Desktop\\GitJavaWorkspace\\GitJava\\src\\properties\\" + fileName));

			is = new BufferedInputStream(
					new FileInputStream("/Users/owner/Desktop/GitJavaWorkspace/GitJava/src/properties/" + fileName));
			Properties props = new Properties();
			props.load(is);

			System.out.println("csh.key1: " + props.getProperty("csh.key1"));
			System.out.println("csh.key2: " + props.getProperty("csh.key2"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e2) {
			e2.printStackTrace();
			System.exit(-1);
		}

	}

}
