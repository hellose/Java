package thread;

//Thread를 생성하는 법과 시작시키는 법 정리
class HowToUseThread {

	private static class MyThreadOne extends Thread {
		// Runnable의 run() 오버라이딩하지 않음
	}

	private static class MyThreadTwo extends Thread {
		@Override
		public void run() {
			System.out.println("MyThreadTwo는 Thread에 구현된 run메서드를 오버라이딩함");
			// Thread를 상속하여 run()메서드를 오버라이딩 하는 경우 Thread 메서드를 사용할 수 있는 장점이 있다.
		}
	}

	public static void main(String[] args) {

		// 람다식을 통해 Runnable 구현
		Runnable runnable1 = () -> {
			System.out.println("람다식을 통해 Runnable의 run() 구현");
			// Thread의 메서드를 사용할 수 없는 단점이 존재
		};

		// 익명 클래스를 통해 Runnable 구현
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 클래스를 통해 Runnable의 run() 구현");
				// Thread의 메서드를 사용할 수 없는 단점이 존재
			}
		};

		Thread th1 = new Thread();
		// 아무것도 안함
		th1.start();

		Thread th2 = new Thread(runnable1);
		th2.start();

		Thread th3 = new Thread(runnable2);
		th3.start();

		MyThreadOne mth1 = new MyThreadOne();
		// 아무것도 안함
		mth1.start();

		MyThreadTwo mth2 = new MyThreadTwo();
		mth2.start();

		try {
			Thread.sleep(1000); //메인 스레드 1초 대기
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			mth2.start(); // start된 스레드는 다시 start될 수 없다.
		} catch (IllegalThreadStateException e) {
			e.printStackTrace();
		}

	}

}
