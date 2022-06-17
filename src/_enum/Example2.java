package _enum;

//example2 - enum 클래스의 상수는 enum 클래스의 필드가 아니라 실제로는 enum 인스턴스에 해당된다.
//각 enum 상수는 싱글톤 enum 인스턴스이다.
enum AnimalType2 {
	DOG, CAT, MONKEY
}

public class Example2 {
	public static void main(String[] args) {

		// enum_class.jpg 이미지 참조
		System.out.println("AnimalType2.CAT instanceof AnimalType2: " + (AnimalType2.CAT instanceof AnimalType2)); // true
	}
}