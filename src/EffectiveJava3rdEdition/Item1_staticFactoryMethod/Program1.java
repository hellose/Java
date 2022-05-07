package EffectiveJava3rdEdition.Item1_staticFactoryMethod;

//인스턴스 생성 방법에 대한 정보를 남길 수 있다.
public class Program1 {

	public static void main(String[] args) {

		Person person1 = new Person(10, "kim");
		Person person2 = new Person(person1);

		Person person3 = new Person(10);
		Person person4 = new Person("kim");

		Person person5 = Person.createInstanceInitOnlyAge(10);
		Person person6 = Person.createInstanceInitOnlyName("kim");
		
	}

}

class Person {
	private int age;
	private String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	Person(int age) {
		this.age = age;
	}

	Person(String name) {
		this.name = name;
	}

	Person(Person person) {
		this.age = person.age;
		this.name = person.name;
	}

	// static factory method - 인스턴스 생성 방법에 대한 정보를 메서드의 이름에 남길 수 있다.
	public static Person createInstanceByParameter(int age, String name) {
		return new Person(age, name);
	}

	public static Person createInstanceByPerson(Person person) {
		return new Person(person);
	}

	public static Person createInstanceInitOnlyAge(int age) {
		return new Person(age);
	}

	public static Person createInstanceInitOnlyName(String name) {
		return new Person(name);
	}

}
