package array.referencetype;

public class Program {

	public static void main(String[] args) {

		Object[] objArr = {};
		System.out.println(objArr.getClass().getName());
		System.out.println(Object[].class.getName());

		String[] strArr = {};
		System.out.println(strArr.getClass().getName());
		System.out.println(String[].class.getName());

		A[] aArr = {};
		System.out.println(aArr.getClass().getName());
		System.out.println(A[].class.getName());
	}

}

class A{}
