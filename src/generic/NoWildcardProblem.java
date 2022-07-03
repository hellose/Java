package generic;

import java.util.ArrayList;

public class NoWildcardProblem {

	public static void main(String[] args) {

		ArrayList<String> stringArrayList = new ArrayList<>();
		stringArrayList.add("가");
		stringArrayList.add("나");
		stringArrayList.add("다");

		//printObjectHashCode(stringArrayList); // 컴파일 에러

	}

	public static void printObjectHashCode(ArrayList<Object> arrayList) {
		// Object의 해시코드를 출력한다.
		for (Object obj : arrayList) {
			System.out.println(obj.hashCode());
		}

	}

}
