package comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {

		MyInteger[] myIntegers = new MyInteger[10];

		for (int i = 0; i < myIntegers.length; i++) {
			myIntegers[i] = new MyInteger((int) (Math.random() * 100));
		}

		// 정렬 전 출력
		ComparatorTest.print(myIntegers);

		// 정렬
		Arrays.sort(myIntegers);

		// 정렬 후 출력
		ComparatorTest.print(myIntegers);

		// Comparator 인터페이스 구현
		Comparator<MyInteger> comparatorMyInteger = new Comparator<MyInteger>() {

			@Override
			public int compare(MyInteger first, MyInteger second) {
				if (first.getI() > second.getI()) {
					return 1;
				} else if (first.getI() == second.getI()) {
					return 0;
				} else {
					return -1;
				}
			}
		};

		int compareResult = comparatorMyInteger.compare(new MyInteger(3), new MyInteger(2));
		System.out.println(compareResult);
	}

	// Comparable 인터페이스 구현
	private static class MyInteger implements Comparable<MyInteger> {

		private int i;

		public MyInteger(int i) {
			this.i = i;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		@Override
		public int compareTo(MyInteger o) {

			if (this.getI() > o.getI()) {
				return 1;
			} else if (this.getI() == o.getI()) {
				return 0;
			} else {
				return -1;
			}
		}

	}

	private static void print(MyInteger[] myIntegers) {
		for (MyInteger item : myIntegers) {
			System.out.print(item.getI() + " ");
		}
		System.out.println();
	}

}
