package DesignPattern.SingletonPattern;

public class Program {

	public static void main(String[] args) {
		
		SingletonOne singletonOne1 = SingletonOne.getInstance();
		SingletonOne singletonOne2 = SingletonOne.getInstance();
		System.out.println(singletonOne1.equals(singletonOne2));
		System.out.println();

		SingletonTwo singletonTwo1 = SingletonTwo.getInstance();
		SingletonTwo singletonTwo2 = SingletonTwo.getInstance();
		System.out.println(singletonTwo1.equals(singletonTwo2));

	}

}
