package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program1 {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			stringList.add(i + "");
		}

		Iterator<String> iter = stringList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}

		// iter.hasNext()가 false인 상태에서 next()를 호출
		// java.util.NoSuchElementException 예외 발생
		System.out.println("iter.hasNext(): " + iter.hasNext());
		iter.next();

	}

}
