package DesignPattern.SingletonPattern;

//TODO - 멀티 스레드 환경 보완 
public class SingletonTwo {

	private static final SingletonTwo INSTANCE = new SingletonTwo();

	private SingletonTwo() {
		if (INSTANCE != null) {
			throw new RuntimeException("singleton instance alreay exists");
		}
	}

	public static SingletonTwo getInstance() {
		return INSTANCE;
	}
}
