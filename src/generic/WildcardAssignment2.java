package generic;

import java.util.ArrayList;

public class WildcardAssignment2 {

	public static void main(String[] args) {

		// 다음 과정이 생략된 것임
		// ArrayList<? extends B> lowerB;
		// ArrayList<C> cList = new ArrayList<C>();
		// lowerB = cList;
		ArrayList<? extends B> lowerB = new ArrayList<C>();
	}
}