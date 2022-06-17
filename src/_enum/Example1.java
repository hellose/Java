package _enum;

//example1 - enum 상수

//관련된 상수를 하나의 enum class 내부에 정의
enum AnimalType1 {
	DOG, CAT, MONKEY;
}

public class Example1 {

	public static void main(String[] args) {
		System.out.println(AnimalType1.CAT); // CAT
		System.out.println(AnimalType1.DOG); // DOG
		System.out.println(AnimalType1.MONKEY); // MONKEY
	}
}
