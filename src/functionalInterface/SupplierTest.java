package functionalInterface;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		System.out.println("1. Supplier �׽�Ʈ");
		// Supplier<T> - ��ü�� �����Ͽ� ����(supply)���ִ� ����
		Supplier<String> supplier = () -> new String("��Ʈ��");
		// Supplier<T>�κ��� ������� ��ü�� get(����)�Ѵ�.
		String madeString = supplier.get();
		System.out.println("supplier�κ��� �������� ��ü: " + madeString); // "����" String ��ü�� ����
	}

}
