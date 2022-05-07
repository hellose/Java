package DesignPattern.SingletonPattern;

public class SingletonOne {

	private static SingletonOne INSTANCE;

	private SingletonOne() {
		if (INSTANCE != null) {
			throw new RuntimeException("singleton instance alreay exists");
		}
	}

	public static SingletonOne getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonOne();
		}
		return INSTANCE;
	}

}
