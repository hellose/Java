package io.util;

public class Util {

	public static void print(byte[] bytes) {
		if (bytes == null) {
			System.out.println("null");
		} else if (bytes.length == 0) {
			System.out.println("empty byte array");
		} else {
			for (int i = 0; i < 200; i++) {
				System.out.println(bytes[i]);
			}
		}
	}

}
