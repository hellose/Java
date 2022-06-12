package thread;

import javax.swing.JOptionPane;

//InterruptedException이 발생하는 경우
//1. 인터럽트가 걸려있는 상태(인터럽트 상태가 true인 상태)에서 sleep()메서드가 호출되는 경우
//2. sleep메서드가 호출된 상태에서 인터럽트가 걸리는 경우(인터럽트 상태가 true)가 되는 경우 
public class InterruptExceptionAndSleep {

	public static void main(String[] args) {

		Thread a = new TestThread();
		a.start();

		while (true) {
			String input = JOptionPane.showInputDialog("인터럽트를 거시겠습니까?");
			a.interrupt();
			System.out.println("main스레드에서 a스레드 인터럽트 상태 확인 " + a.isInterrupted());

		}

	}
}

class TestThread extends Thread {
	public void run() {
		String tab = "\t\t\t\t\t\t";
		while (true) {
			try {
				System.out.println(tab + "자기자신에서 인터럽트 상태 확인 " + this.isInterrupted());
				System.out.println(tab + "try1- sleep상태");
				Thread.sleep(5000);
				System.out.println();
				System.out.println(tab + "try2- sleep에서 깨어남");
				System.out.println(tab + "try3- 작업중....빈 반복문 수행");
				for (long l = 0; l < 3000000L; l++) {
					System.out.println("-");
				}
				System.out.println(tab + "try4- 작업 끝");

			} catch (InterruptedException e) {
				System.out.println(tab + "InterruptedException 발생");
				System.out.println(tab + "인터럽트 상태: " + this.isInterrupted());
			}
		}

	}
}