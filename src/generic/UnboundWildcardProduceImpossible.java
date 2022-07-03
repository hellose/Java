package generic;

import java.util.ArrayList;

public class UnboundWildcardProduceImpossible {

	public static void main(String[] args) {
		produceItem(new ArrayList<Object>());
		produceItem(new ArrayList<String>());
		produceItem(new ArrayList<Number>());
		produceItem(new ArrayList<Integer>());
		produceItem(new ArrayList<int[]>());
	}

	public static void produceItem(ArrayList<?> unboundArrayList) {
		// ArrayList<Object>이외의 타입이 넘어올 수 있다.
		// unboundArrayList.add(new Object()); // 컴파일 에러

		// ArrayList<String>이외의 타입이 넘어올 수 있다.
		// unboundArrayList.add("test"); // 컴파일 에러

		// 컴파일러는 이러한 객체 추가(produce) 작업인
		// ArrayList의 add()메서드를 사용할 수 없게 한다.
	}

}
