package io.fileNewLineTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {

	// windows에서 개행문자 \r\n 확인
	// unix의 경우 \n
	public static void main(String[] args) throws Exception {
		String str = "C:\\Users\\owner\\Desktop\\NewLineTest.txt";
		compareFile(str);
	}

	public static void compareFile(String name) throws Exception {
		Path path = Paths.get(name);
		String content = Files.readString(path);

		System.out.println("string 길이: " + content.length());
		System.out.println("--- 원본 파일 ---");
		System.out.println(content);
		System.out.println();

		content = content.replace('\r', 'R');
		content = content.replace('\n', 'N');
		content = content.replace(' ', 'S');
		content = content.replace('\t', 'T');

		System.out.println("--- 변경된 파일 ---");
		System.out.println(content);
		System.out.println();
	}

}
