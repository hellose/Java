package _enum;

import java.util.HashMap;
import java.util.Map;

public class Example6 {
	public static void main(String[] args) {
		MyEnum.staticMethod();
	}
}

enum MyEnum {
	ONE(1), TWO(2), THREE(3);

	private final int key;
	private static Map<Integer, MyEnum> lookUp = new HashMap<>();

	static {
		System.out.println("static block");
//		for (MyEnum item : MyEnum.values()) {
//			lookUp.put(item.key, item);
//		}
	}

	public static void staticMethod() {
	}

	private MyEnum(int key) {
		System.out.println("constructor - key argument: " + key);
		this.key = key;
	}

}
