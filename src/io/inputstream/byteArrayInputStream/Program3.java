package io.inputstream.byteArrayInputStream;

import java.io.ByteArrayInputStream;

//mark메서드, reset메서드
public class Program3 {

	public static void main(String[] args) {

		byte[] src = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		ByteArrayInputStream bais = new ByteArrayInputStream(src);
		System.out.println("mark기능 지원 여부 확인: " + bais.markSupported());
		System.out.println("읽을 수 있는 개수: " + bais.available());
		System.out.println();

		// 현재 읽힐 지점을 마킹한다.
		bais.mark(10000); // ByteArrayInputStream에서 넘길 인자는 의미가 없다.
		System.out.println("두번 읽기");
		System.out.println(bais.read());
		System.out.println(bais.read());
		System.out.println("읽을 수 있는 개수: " + bais.available());
		System.out.println();

		// 읽힐 지점을 마크지점으로 되돌린다.
		bais.reset();
		System.out.println("0번 지점으로 돌아간다.");
		System.out.println("읽을 수 있는 개수: " + bais.available());
		System.out.println("두번 읽기");
		System.out.println(bais.read());
		System.out.println(bais.read());
		System.out.println("읽을 수 있는 개수: " + bais.available());

	}

}
