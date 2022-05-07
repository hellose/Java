package array.copy;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {

		String[] original = { "test1", "test2", "test3" };

		System.out.println("원본");
		System.out.println("길이: " + original.length);
		for (String item : original) {
			System.out.println("값: " + item.toString());
		}
		System.out.println();

		String[] des = Arrays.copyOf(original, 10);

		System.out.println("결과");
		System.out.println("길이: " + des.length); 
		for (String item : des) {
			System.out.println("값: " + item.toString()); //4번째부터 null로 초기화되어 NPE발생
		}
		System.out.println();
	}

}
