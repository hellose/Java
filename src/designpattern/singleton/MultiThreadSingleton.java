package designpattern.singleton;

class MultiThreadSingleton {

	private static MultiThreadSingleton INSTANCE = null;

	private MultiThreadSingleton() {

	}

	public static synchronized MultiThreadSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MultiThreadSingleton();
		}

		return INSTANCE;
	}

}
