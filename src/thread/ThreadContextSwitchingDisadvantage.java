package thread;

//TODO - 코어개수 확인해보기
public class ThreadContextSwitchingDisadvantage {

	public static void main(String[] args) {

		// 1. 메인 스레드 하나로
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.print(new String("@"));
		}
		System.out.println();
		System.out.println(System.currentTimeMillis() - start1);

		// 2. 메인 스레드 하나와 작업 스레드 하나 나눠서

		// 작업 스레드 생성
		Runnable r = () -> {
			for (int i = 0; i < 5000; i++) {
				System.out.print(new String("@"));
			}
			System.out.println();
			System.out.println(System.currentTimeMillis());
		};
		Thread worker = new Thread(r);

		System.out.println(System.currentTimeMillis()); // 시작

		worker.start(); // 워커 스레드 작업 시킴
		for (int i = 0; i < 5000; i++) {
			System.out.print(new String("@"));
		}
		System.out.println();
		// 메인 스레드 끝날때 작업 완료 시간 체크
		System.out.println(System.currentTimeMillis());

	}

}
