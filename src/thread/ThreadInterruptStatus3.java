package thread;

//Thread.interrupted()는 인터럽트 상태 확인후 인터럽트 상태를 false로 초기화
public class ThreadInterruptStatus3 {

	private static class MyThread extends Thread {

		@Override
		public void run() {
			String tab = "\t\t\t\t\t\t";
			while (true) {
				for (long i = 0; i < 600000000L; i++) {
				}
				System.out.println(tab + "자기 자신에서 인터럽트 확인 " + Thread.interrupted());
			}

		}

	}

	public static void main(String[] args) throws Exception {
		Thread worker = new MyThread();
		worker.start();

		while (true) {
			Thread.sleep(1000);
			worker.interrupt(); // main스레드에서 1초마다 worker 스레드에 인터럽트를 건다.
		}

	}
}
