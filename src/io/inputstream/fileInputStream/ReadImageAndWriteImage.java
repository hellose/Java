package io.inputstream.fileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadImageAndWriteImage {

	public static void main(String[] args) {

		try {
			File file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\inputstream\\fileInputStream\\readImage.jpg");
			FileInputStream fis = new FileInputStream(file);
			int imageByteSize = fis.available();
			System.out.println(imageByteSize);
			byte[] bytesDogImage = new byte[imageByteSize];
			fis.read(bytesDogImage);
			fis.close();

			file = new File(
					"C:\\Users\\sehyun\\Desktop\\sts_work\\JavaStudy\\src\\io\\outputStream\\fileOutputStream\\writtenImage.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytesDogImage);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
