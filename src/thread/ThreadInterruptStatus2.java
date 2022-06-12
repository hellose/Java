package thread;

public class ThreadInterruptStatus2 {

	private static class MyThread extends Thread {
		@Override
		public void run() {
			String tab = "\t\t\t\t\t\t";
			while (true) {
				for (long i = 0; i < 600000000L; i++) {
				}
				System.out.println(tab + "worker 스레드 자기 자신에서 인터럽트 상태 확인 " + this.isInterrupted());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Thread worker = new MyThread();
		worker.start();

		Thread.sleep(2000);
		worker.interrupt();

		while (true) {
			for (long i = 0; i < 600000000L; i++) {
			}
			System.out.println("main스레드에서 worker스레드의 인터럽트 상태 체크 " + worker.isInterrupted());
		}

	}
}
