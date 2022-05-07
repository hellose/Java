package EffectiveJava3rdEdition.Item1_staticFactoryMethod;

//생성자를 통해 생성된 인스턴스는 해당 클래스 타입을 리턴한다( 참조변수에 담을 때 자동 up-casting이 일어나는 것과는 별개의 관점!)
//static factory method는 리턴 타입을 활용할 수 있다.
public class Program3 {

	public static void main(String[] args) {
		// static factory method 활용 전
		new Dog("dog1").sound();
		new Cat("cat1").sound();
		System.out.println();

		// static factory method 활용 후 - 내부적으로 soundable 구현체 인스턴스가 어떻게 생성되는지 몰라도 된다.
		// 또한 구현체에서는 인터페이스의 static메서드인 getCatWithName, getDogWithName 메서드를 사용할 수 없으므로 문제가 되지 않는다.
		// package staticMethod의 Program.java 참고
		
		Soundable.getDogWithName("dog2").sound();
		Soundable.getCatWithName("cat2").sound();

	}

}

interface Soundable {

	void sound();

	// static factory method
	static Soundable getDogWithName(String name) {
		return new Dog(name);
	}

	static Soundable getCatWithName(String name) {
		return new Cat(name);
	}

}

class Dog implements Soundable {
	private String name;

	Dog(String name) {
		this.name = name;
	}

	@Override
	public void sound() {
		System.out.println("i m dog, my name is " + name);
	}
}

class Cat implements Soundable {
	private String name;

	Cat(String name) {
		this.name = name;
	}

	@Override
	public void sound() {
		System.out.println("i m cat, my name is " + name);
	}
}
