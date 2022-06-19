package io.outputstream.byteArrayOuputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Program2 {

	public static void main(String[] args) {
		byte[] bytes = { 1, 2, 3, 4, 5 };
		ByteArrayOutputStream buffer = new ByteArrayOutputStream(3);
		for (int i = 0; i < bytes.length; i++) {
			buffer.write(bytes[i]);
		}

		try {
			ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
			buffer.writeTo(buffer2); // buffer에 있는 모든 바이트들을 buffer2로 write한다.
			System.out.println(buffer2.size());
			byte[] bytes2 = buffer2.toByteArray();
			for (int i = 0; i < bytes2.length; i++) {
				System.out.print(bytes2[i] + ",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
