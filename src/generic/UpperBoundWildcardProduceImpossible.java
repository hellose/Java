package generic;

import java.util.ArrayList;

public class UpperBoundWildcardProduceImpossible {

	public static void main(String[] args) {
		// produceItem 메서드에 대입 불가
		// produceItem(new ArrayList<Object>());
		// produceItem 메서드에 대입 불가
		// produceItem(new ArrayList<String>());

		ArrayList<Number> numbers = new ArrayList<>();
		produceItem(numbers);

		ArrayList<Integer> integers = new ArrayList<>();
		produceItem(integers);
	}

	public static void produceItem(ArrayList<? extends Number> upperBoundArrayList) {
		// upperBoundArrayList.add 사용 -> 컴파일 에러
		
		// 오로지 null만 추가 가능
		upperBoundArrayList.add(null);
	}

}
