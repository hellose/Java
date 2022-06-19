package io.inputstream.fileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// LF(line feed) 커서를 아래줄로 이동 13
// CR(carriage return) 커서를 맨 앞으로 이동 10
// SPACE 띄어쓰기 32
// '0' -> 48
// '.' -> 46

//read() 한바이트메서드, 바이트배열메서드
//skip() 몇바이트 건너 뜀
public class Program1 {

	public static void main(String[] args) {

		try {
			File file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\fileInputStream\\test1.txt");
			FileInputStream fis = new FileInputStream(file);
			System.out.println("파일에서 읽을 수 있는 바이트 개수: " + fis.available());
			while (fis.available() != 0) {
				System.out.println((char) fis.read());
			}
			fis.close();
			System.out.println();

			file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\fileInputStream\\test2.txt");
			fis = new FileInputStream(file);
			System.out.println("파일에서 읽을 수 있는 바이트 개수: " + fis.available());
			while (fis.available() != 0) {
				System.out.println(fis.read());
			}
			fis.close();
			System.out.println();

			file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\fileInputStream\\test3.txt");
			fis = new FileInputStream(file);
			System.out.println("파일에서 읽을 수 있는 바이트 개수: " + fis.available());
			fis.skip(2); // 두번 스킵
			System.out.println(fis.read());
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	/*
	 * public void close() throws IOException { synchronized (closeLock) { if
	 * (closed) { //닫혀있으면 return return; } closed = true; //안닫혀있으면 닫음 } if (channel
	 * != null) { channel.close(); //채널을 닫음 }
	 * 
	 * fd.closeAll(new Closeable() { public void close() throws IOException {
	 * close0(); } }); }
	 */

}
