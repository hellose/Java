package io.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public static void main(String[] args) {

		CharArrayReaderTest();

	}

	public static void CharArrayReaderTest() {

		char[] chars = { 'a', 'b', 'c' };
		CharArrayReader reader = new CharArrayReader(chars);

		try {
			for (int i = 0; i < chars.length; i++) {
				System.out.println((char) (reader.read()));
			}
			System.out.println(reader.ready()); // 스트림의 끝에 도달하면 ready() -> false
		} catch (IOException e) {

		}
	}

	public static void InputStreamReaderTest() {
		InputStreamReader reader;
	}

	public static void FileReaderTest() {
		FileReader reader;
	}

}
