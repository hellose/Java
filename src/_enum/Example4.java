package _enum;
//example4 - enum 활용

enum AnimalType4 {
	DOG, CAT, MONKEY
}

//클래스 메서드 
//values() - 모든 enum상수에 해당하는 enum인스턴스를 담은 배열 리턴
//valueOf("문자열") - 문자열과 일치하는 enum상수에 해당하는 인스턴스 리턴

//인스턴스 메서드
//ordinal() - 현재 enum상수가 선언된 번째 수 int 리턴 (0이 처음) (부모클래스 Enum<E>의 int ordinal 필드에 저장됨)
//name() or toString() - enum상수 문자열 String 리턴 (부모클래스 Enum<E>의 name필드에 저장됨)
//equals() - Object의 equals()와 같이 객체 비교
//compareTo(E e) - enum 클래스에 지정된 순서 비교.

public class Example4 {

	public static void main(String[] args) {

		System.out.println("1. enum 상수 스트링 값 - 인스턴스.name() 또는 인스턴스.toString()");

		// name()은 toString()과 같다. 두 메서드 모두 내부 name 필드를 출력
		System.out.println("enum 상수 DOG의 문자열 " + AnimalType4.DOG.name());
		System.out.println();

		System.out.println("2. 각 enum 상수가 선언된 위치(첫 번째 인덱스는 0) - 인스턴스.ordinal()");

		System.out.println("DOG는 몇번째 선언?: " + AnimalType4.DOG.ordinal());
		System.out.println("CAT은 몇번째 선언?: " + AnimalType4.CAT.ordinal());
		System.out.println();

		System.out.println("3. 모든 enum상수(enum 클래스 인스턴스)를 포함하는 배열 리턴");

		AnimalType4[] animalArray = AnimalType4.values();
		for (AnimalType4 animal : animalArray) {
			System.out.println(animal.toString());
		}
		System.out.println();

		System.out.println("4. 클래스.valueOf(\"enum상수 문자열\")");
		AnimalType4 animal = AnimalType4.valueOf("DOG");
		System.out.println("animal.hashCode():" + animal.hashCode());
		System.out.println("AnimalType4.DOG.hashCode(): " + AnimalType4.DOG.hashCode());
		System.out.println();

		System.out.println("5. 객체 주소값 비교 equals()");
		System.out.println(AnimalType4.DOG.equals(animal)); // 객체 주소값 비교
		System.out.println();

		System.out.println("6. 선언된 차이 비교");
		System.out.println(AnimalType4.DOG.compareTo(AnimalType4.MONKEY));
		// self.ordinal - other.ordinal;
		// 0 - 2 -> -2

	}

}
