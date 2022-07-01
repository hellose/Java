package functionalInterface;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {

		System.out.println("1. Function �׽�Ʈ");
		// Function<T,R> - ���� �˰��ִ� �޼���,�Լ� ������ �� �� �ִ� �Լ��� �������̽�
		// TŸ�� ��ü�� �Ѱ��ָ� �޼���,�Լ� ������ ���� RŸ�� ��ü�� �����Ѵ�.
		Function<String, Integer> func = str -> str.length(); // ������ ���ڿ��� ���̸� ����
		// Function<T,R>�� apply(����)�Ѵ�.
		int stringLength = (int) func.apply("���ڿ��Ǳ��̴�");
		System.out.println("���ڿ��Ǳ��̴�: " + stringLength);

	}

}
