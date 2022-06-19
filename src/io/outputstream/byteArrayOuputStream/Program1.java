package io.outputstream.byteArrayOuputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

//write()메서드, toByteArray()메서드
public class Program1 {

	public static void main(String[] args) {

		byte[] bytes = { 1, 2, 3, 4, 5 };

		// new ByteArrayOutputStream(); -> default 32size의 byte배열 생성
		ByteArrayOutputStream buffer = new ByteArrayOutputStream(3); // 사이즈가 부족하면 자동으로 늘리는 코드 존재
		System.out.println("buffer에 bytes의 모든 바이트를 한바이트씩 write한다");
		for (int i = 0; i < bytes.length; i++) {
			// write 메서드1 - 버퍼에 한바이트를 write한다.
			buffer.write(bytes[i]);
		}
		System.out.println("몇 바이트가 차있는지 체크: " + buffer.size());

		System.out.println("버퍼에 있는 값을 바이트 배열로 변환");
		byte[] resultArray;
		resultArray = buffer.toByteArray();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + ",");
		}
		System.out.println();

		try {
			// write 메서드2 - 인자의 바이트 배열의 모든 값을 버퍼에 write한다.
			System.out.println("buffer에 bytes의 모든 바이트를 write한다");
			buffer.write(bytes);
			System.out.println("몇 바이트가 차있는지 체크: " + buffer.size());
			System.out.println("버퍼에 있는 값을 바이트 배열로 변환");
			byte[] resultArray2;
			resultArray2 = buffer.toByteArray();
			for (int i = 0; i < resultArray2.length; i++) {
				System.out.print(resultArray2[i] + ",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
