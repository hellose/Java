package io.inputstream.bufferedInputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//전체 파일을 배열에 한번에 쓰는 경우 native call이 한번이기 때문에 FileInputStream과 BufferedInputStream의 속도차이가 없었다.
//한번에 읽는 양이 작아질 수록 속도차이가 심해진다.
public class BufferedInputStreamVSFileInputStream {

	public static void main(String[] args) {
		try {
			File file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\bufferedInputStream\\DogImage.jpg");

			// FileInputStream 시간 측정
			FileInputStream fis = new FileInputStream(file);
			int size = fis.available();
			long startTime1 = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				fis.read(); // 하드 디스크로부터 한바이트씩 읽음
			}
			long endTime1 = System.currentTimeMillis();
			System.out.println(endTime1 - startTime1);
			fis.close();
			System.out.println();

			// BufferedInputStream 시간 측정
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis); // default buffer 8192 byte
			size = bis.available();
			long startTime2 = System.currentTimeMillis();

			for (int i = 0; i < size; i++) {
				// 하드 디스크로부터 8192바이트를 읽고 버퍼에서 1바이트를 읽음.
				// 다음 반복시 버퍼 배열에서 읽음.
				// 버퍼에서 모두 읽으면 다시 버퍼에 8192바이트를 채움
				bis.read();
			}
			long endTime2 = System.currentTimeMillis();
			System.out.println(endTime2 - startTime2);
			fis.close();
			bis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
