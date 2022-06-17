package _enum;
//example3 - enum 클래스의 필드와 생성자 사용법1

enum AnimalTypeTest {

	// enum 상수 이외에 필드,생성자,메서드 선언이 존재하면
	// enum 상수와 필드,생성자,메서드를 구분하기 위해 마지막 enum상수 뒤에 ;를 붙여야한다.
	DOG, CAT, MONKEY;

	// 생성자 선언이 없으면 는 아래와 같은 private, 파라메터 없는 생성자가 생성된다.
	private AnimalTypeTest() {
	}

}

enum AnimalType3 {
	// enum 클래스는 상수 선언이 가장 먼저 나와야 한다.(필드 선언 후 enum 상수 -> 에러)

	// 각 enum 상수는 enum 클래스 내부에 선언된 생성자중 하나를 통해 AnimalType3 인스턴스가 만들어진다.
	DOG, // 생성자1 -> DOG()와 동일
	CAT("고양이"), // 생성자2
	MONKEY("원숭이", 4); // 생성자3

	private String name = "이름 설정 필요";
	private int age = 0;

	// 생성자1
	private AnimalType3() {

	}

	// 생성자2
	private AnimalType3(String name) {
		this.name = name;
	}

	// 생성자3
	private AnimalType3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getter
	public String getName() {
		return name;
	}

	// getter
	public int getAge() {
		return age;
	}

}

public class Example3 {
	public static void main(String[] args) {

		AnimalType3 dog = AnimalType3.DOG;
		System.out.println("dog 이름: " + dog.getName() + ", 나이: " + dog.getAge());
		// dog 이름: 이름 설정 필요, 나이: 0

		AnimalType3 cat = AnimalType3.CAT;
		System.out.println("cat 이름: " + cat.getName() + ", 나이: " + cat.getAge());
		// cat 이름: 고양이, 나이: 0

		AnimalType3 monkey = AnimalType3.MONKEY;
		System.out.println("monkey 이름: " + monkey.getName() + ", 나이: " + monkey.getAge());
		// monkey 이름: 원숭이, 나이: 4
		
		
	}
}