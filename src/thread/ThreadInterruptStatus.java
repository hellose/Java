package thread;

//main스레드에서 작업 스레드에 인터럽트를 건다.
//작업 스레드의 인터럽트 상태 체크 코드
public class ThreadInterruptStatus {

	private static class MyThread extends Thread {

		public MyThread(String threadName) {
			super(threadName);
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			while (true) {
				if (this.isInterrupted()) {
					System.out.println(threadName + " 인터럽트 상태 true");
				} else {
					System.out.println(threadName + " 인터럽트 상태 false");
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread th = new MyThread("worker1");
		th.start();

		try {
			Thread.sleep(1000); // main스레드 1초 쉼
		} catch (Exception e) {

		}

		th.interrupt(); // main스레드에서 작업 스레드에 인터럽트를 건다.

	}

}
