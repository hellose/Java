package thread;

//try의 코드에서 InterruptedException이 절대 발생할 수 없으면 catch문에서 컴파일 에러가 난다.
public class InterruptedExceptionTryCatchUnreachable {

	private static class MyThread extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 1000000000; i++) {
					System.out.println("-");
				}
				//InterruptedException을 던지는 스레드 메서드가 없으면 catch문에서 컴파일 에러 발생
				Thread.sleep(2000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread th = new MyThread();
		th.start();

	}
}

