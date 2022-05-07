package EffectiveJava3rdEdition.Item1_staticFactoryMethod;

//인스턴스 생성을 통제할 수 있다.
public class Program2 {

	public static void main(String[] args) {
		PersonSingleton instance = PersonSingleton.getInstance();
		System.out.println("instance: " + System.identityHashCode(instance));
		PersonSingleton instance2 = PersonSingleton.getInstance();
		System.out.println("instance2: " + System.identityHashCode(instance2));

	}

}

class PersonSingleton {
	//final강제 -> 변경 불가능
	private static final PersonSingleton INSTANCE = new PersonSingleton();
	
	//외부에서 인스턴스를 생성할 경우 예외를 던짐
	private PersonSingleton() {
		if (INSTANCE != null) {
			throw new RuntimeException("singleton instance alreay exists");
		}
	}

	// static factory method - 인스턴스 통제
	public static PersonSingleton getInstance() {
		return INSTANCE;
	}
}