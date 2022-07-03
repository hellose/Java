package generic;

import java.util.ArrayList;

public class RawType3 {

	public static void main(String[] args) {

		ArrayList<String> strList = new ArrayList<>();
		rawTypeTest(strList);

		String str = strList.get(0); // runtime 에러
	}

	public static void rawTypeTest(ArrayList list) {
		list.add(new Object());
	}

}
