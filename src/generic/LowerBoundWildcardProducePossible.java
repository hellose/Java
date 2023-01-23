package generic;

import java.util.ArrayList;

public class LowerBoundWildcardProducePossible {

	public static void main(String[] args) {

		ArrayList<Object> objList = new ArrayList<>();
		produceItem(objList);

		ArrayList<A> aList = new ArrayList<>();
		produceItem(aList);

		ArrayList<B> bList = new ArrayList<>();
		produceItem(bList);
	}

	public static void produceItem(ArrayList<? super B> lowerBoundArrayList) {
		lowerBoundArrayList.add(new B());
		lowerBoundArrayList.add(new C());
		lowerBoundArrayList.add(new D());
		
		//null 추가 가능
		lowerBoundArrayList.add(null);
	}

}
