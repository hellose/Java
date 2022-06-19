package io.inputstream.byteArrayInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

//read메서드 종류
public class Program2 {

	public static void main(String[] args) {
		byte[] src = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		ByteArrayInputStream bais = new ByteArrayInputStream(src); // 읽힐 구간 src 전체

		byte[] desti = new byte[10];
		//read 메서드 1
		int readCount = bais.read(desti, 2, 5); // desti배열에 채움, desti의 2번 인덱스부터 채움, 5번 읽어옴
		System.out.println("읽힌 개수: " + readCount);
		for (int i = 0; i < desti.length; i++) {
			System.out.print(desti[i] + ",");
		}
		System.out.println();

		try {
			desti = new byte[10];
			//read 메서드 2
			readCount = bais.read(desti); // 배열의 처음부터 끝까지 읽힐 수 있을 때까지 다 채운다.
			System.out.println("읽힌 개수: " + readCount);
			for (int i = 0; i < desti.length; i++) {
				System.out.print(desti[i] + ",");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			desti = new byte[10];
			readCount = bais.read(desti); // 읽을 것이 없어 남은 부분은 채워지지 않는다.
			System.out.println("읽힌 개수: " + readCount);
			for (int i = 0; i < desti.length; i++) {
				System.out.print(desti[i] + ",");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
