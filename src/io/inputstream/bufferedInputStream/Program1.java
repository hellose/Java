package io.inputstream.bufferedInputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.util.Util;

public class Program1 {

	public static void main(String[] args) {
		try {
			File file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\bufferedInputStream\\readImage.jpg");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream buf = new BufferedInputStream(fis); // default buffer 8192 byte

			byte[] bytes = new byte[buf.available()];

			buf.read(bytes, 0, 100);
			Util.print(bytes);
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
