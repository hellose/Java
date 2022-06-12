package thread;

//멀티 스레드 공유 객체 접근 문제 (스레드 동기화의 필요성)
public class SharedInstanceProblem {

	public static void main(String[] args) {

		Counter sharedCounter = new Counter();
		Thread a = new Thread(new MyRunnable(sharedCounter), "스레드1");
		Thread b = new Thread(new MyRunnable(sharedCounter), "스레드2");
		a.start();
		b.start();

		try {
			Thread.sleep(2000); // 위의 두 스레드가 끝나기 위해 잠시 main스레드 정지
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(sharedCounter.getCount()); // main스레드에서 Counter객체의 count값 확인
	}
}

class Counter {
	private int count = 0;

	public void increase() { // 1증가시키는 메서드
		count++;
	}

	public int getCount() { // count를 확인하는 메서드
		return count;
	}

}

class MyRunnable implements Runnable {

	Counter counter;

	MyRunnable(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() { // 스레드 작업 내용- Counter의 increase메서드를 십만번 호출하여 count값을 십만 증가시킴
		System.out.println(Thread.currentThread().getName() + " 시작");
		for (int i = 1; i <= 100000; i++) {
			counter.increase();
		}
		System.out.println(Thread.currentThread().getName() + " 종료");
	}

}