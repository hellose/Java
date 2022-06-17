package _enum;
// example5 - switch case문에 사용될 수 있는 enum 상수

enum AnimalType5 {
	DOG, CAT, MONKEY
}

public class Example5 {

	public static void main(String[] args) {

		AnimalType5 animal = AnimalType5.DOG;

		switch (animal) {
		// switch의 인자의 enum 클래스 추론으로 인해 enum클래스는 생략할 수 있는 것이며
		// case AnimalType5.DOG: 는 에러가 난다.
		case DOG:
			System.out.println("dog");
		case CAT:
			System.out.println("cat");
		case MONKEY:
			System.out.println("monkey");
		default:
			System.out.println("no animal");
		}
	}
}
