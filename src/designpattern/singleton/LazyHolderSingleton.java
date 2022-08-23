package designpattern.singleton;

class LazyHolderSingleton {

	private LazyHolderSingleton() {
	}

	public static LazyHolderSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		// 클래스 메모리 로딩시 INSTANCE 변수 초기화
		private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
	}
}
