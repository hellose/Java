package io.inputstream.byteArrayInputStream;

import java.io.ByteArrayInputStream;

//1. ByteArrayOutputStream 생성자
//2. available()
public class Program1 {

	public static void main(String[] args) {

		byte[] src = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

		// 생성자 1 - 읽을 대상 src배열의 전체
		ByteArrayInputStream bais = new ByteArrayInputStream(src);
		System.out.println("읽기 가능한 개수: " + bais.available());
		// available() -> 소스로 설정된 바이트 배열로부터 몇개의 바이트를 읽을 수 있는지

		// 읽어올 수 없을 떄까지 while반복
		while (bais.available() != 0) {
			System.out.print(bais.read() + ","); // 한 바이트를 읽는다.
		}
		System.out.println();
		System.out.println("읽기 가능한 개수: " + bais.available());
		System.out.println();

		// 생성자 2 - 읽힐 대상 src배열의 10번 인덱스부터 7개로 결정됨
		ByteArrayInputStream bais2 = new ByteArrayInputStream(src, 10, 7); 
		System.out.println("읽기 가능한 개수: " + bais2.available());
		// 전체 읽기
		while (bais2.available() != 0) {
			System.out.print(bais2.read() + ","); // 하나 읽은 값
		}
		System.out.println();
		System.out.println("읽기 가능한 개수: " + bais2.available());

	}

}
