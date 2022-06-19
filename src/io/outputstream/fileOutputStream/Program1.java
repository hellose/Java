package io.outputstream.fileOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//생성자에 설정된 파일로 바이트를 write하는 스트림
public class Program1 {

	public static void main(String[] args) {
		try {
			File file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\outputstream\\fileOutputStream\\FileOutputStreamTest.txt");
			FileOutputStream fos = new FileOutputStream(file);
			// = new FileOutputStream(file, false);
			// false -> 덮어쓰기, true -> 기존 파일 맨 뒤 붙이기

			// write 메서드 - 한 바이트를 파일에 write
			fos.write(46); // '.' -> 46

			// write 메서드 - 바이트 배열의 모든 바이트를 파일에 write
			byte[] bytes = { 48, 49, 50, 51, 52 };
			fos.write(bytes);
			fos.write(bytes, 1, 2); // bytes배열의 1번 인덱스부터 2개의 바이트 값을 파일에 write
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
