package functionalInterface;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		System.out.println("1. Consumer �׽�Ʈ");
		// Consumer<T> - ���ڷ� ��ü�� �Ѱ��ָ� ��ü�� ���(consume)�ϴ� ����
		Consumer<String> consumer = str -> System.out.println(str);
		String hello = "hello";
		// Consumer<T>�� ��ü�� �̿��� �� �ֵ��� accept(��ħ)�Ѵ�.
		consumer.accept(hello);
	}
}
