package wrapper.Boolean;

//Boolean class Test Program
public class Program {

	public static void main(String[] args) {

		// 1. 인스턴스 멤버 value
		// private final boolean value;
		// Wrapper 객체의 boolean 값
		// read-only로 변경 불가능 위해 final임
		Boolean boxBoolean = new Boolean(true); // 생성자를 사용하면 인스턴스 생성 남용 발생 가능
		boolean value = boxBoolean.booleanValue(); // wrapping값 리턴 메서드

		// 2. 클래스 멤버 TRUE, FALSE
		// public static final Boolean TRUE = new Boolean(true);
		// public static final Boolean FALSE = new Boolean(false);
		Boolean t = Boolean.TRUE;
		Boolean f = Boolean.FALSE;
		System.out.println("Boolean.TURE: " + System.identityHashCode(t));
		System.out.println("Boolean.FALSE: " + System.identityHashCode(f));
		System.out.println();

		// 3. String에 맞는 클래스 멤버 TRUE 또는 FALSE 인스턴스 return
		Boolean t2 = Boolean.valueOf(true); // Boolean t = Boolean.valueOf("true");
		Boolean f2 = Boolean.valueOf(false); // Boolean t = Boolean.valueOf("대소문자TrUe가아닌스트링이면false");
		System.out.println("Boolean.valueOf(true): " + System.identityHashCode(t2));
		System.out.println("Boolean.valueOf(false): " + System.identityHashCode(f2));
		System.out.println();

		// 4. hashCode() - 인스턴스 멤버 boolean value가 true이냐 false이냐에 따라 결정
		Boolean t3 = new Boolean(true);
		Boolean t4 = new Boolean(true);
		System.out.println("new Boolean(true).hashCode(): " + t3.hashCode());
		System.out.println("new Boolean(true).hashCode(): " + t4.hashCode());
		System.out.println();
		Boolean f3 = new Boolean(false);
		Boolean f4 = new Boolean(false);
		System.out.println("new Boolean(false).hashCode(): " + f3.hashCode());
		System.out.println("new Boolean(false).hashCode(): " + f4.hashCode());
		System.out.println();

		// 5. equals(Object another) - instanceof Boolean이 참이고 내부 value값이 같으면 true
		Boolean t5 = new Boolean(true);
		Boolean t6 = new Boolean(true);
		Object obj = new Object();
		System.out.println("new Boolean(true).equals(obj): " + t5.equals(obj));
		System.out.println("new Boolean(true).equals(new Boolean(true)): " + t5.equals(t6));

	}

}
