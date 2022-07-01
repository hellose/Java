package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class Program1 {

	public static void main(String[] args) {

		int i = ((int) (Math.random() * 10)) + 1; // 1~10�� ���� int��

		String nullableString;
		// i�� ���� ���� nullableString�� null�ϼ��� �ƴ� ���� ����
		if (i <= 5) {
			nullableString = null;
		} else {
			nullableString = "Hello";
		}

		// nullableString�� null�� ��� otherString�� ����� ����
		String otherString = "hi";

		Optional<String> stringOptional = Optional.ofNullable(nullableString);

		// isPresent()�� get()�� ����ϴ� ��
		if (stringOptional.isPresent()) {
			System.out.println(stringOptional.get());
		} else {
			System.out.println(otherString);
		}

		// isPresent()�� ������� �ʰ� orElse(T t)�� ����ϴ� ��
		System.out.println(stringOptional.orElse(otherString));

		// orElse(T t)�� t�� �������� �ʰ� Supplier<T>�� ����ϴ� ��
		Supplier<String> hiStringSupplier = () -> "hi";
		System.out.println(stringOptional.orElseGet(hiStringSupplier));

	}

}
