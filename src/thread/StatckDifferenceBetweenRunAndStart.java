package thread;

//run()과 start()메서드의 차이 (stack확인)
public class StatckDifferenceBetweenRunAndStart {

	public static void main(String[] args) {

		// 1. run메서드 호출 스택 확인
		System.out.println("run()메서드 호출스택 확인");
		new MyThread().run();

		System.out.println();

		// 2. start메서드 호출 스택 확인
		System.out.println("start()메서드 호출스택 확인");
		new MyThread().start();

	}

	private static class MyThread extends Thread {

		@Override
		public void run() {
			throwException();
		}

		public void throwException() {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
