package designpattern.factory.abstractfactory.beforeuse;

//출처
//https://victorydntmd.tistory.com/300
//https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile21.uf.tistory.com%2Fimage%2F998FC33C5C25BD7C026317

//컴퓨터는 무조건 하나의 회사의 제품으로만 생성되어야 한다. 
//LG컴퓨터 구성-> LG마우스,LG키보드,LG본체....

//추상 팩토리 패턴을 사용하지 않고 팩토리 메서드 패턴만 사용할 경우의 문제
//1. 컴퓨터에는 스피커가 달려야 할때
//2. IBM 컴퓨터가 추가되어야 할떄
class Program {
	public static void main(String[] args) {
		ComputerFactory computerFactory = new ComputerFactory();
		Computer computer = computerFactory.createComputer("LG");
	}
}

//키보드
interface Keyboard {
}

class LGKeyboard implements Keyboard {
	public LGKeyboard() {
		System.out.println("LG 키보드 생성");
	}
}

class SamsungKeyboard implements Keyboard {
	public SamsungKeyboard() {
		System.out.println("Samsung 키보드 생성");
	}
}

//2. IBM컴퓨터에 사용될 IBM 키보드 추가 필요....
class IBMKeyboard implements Keyboard {
	public IBMKeyboard() {
		System.out.println("IBM 키보드 생성");
	}
}

//키보드 Factory
class KeyboardFactory {
	public Keyboard createKeyboard(String type) {
		Keyboard keyboard = null;

		switch (type) {
		case "LG":
			keyboard = new LGKeyboard();
			break;

		case "Samsung":
			keyboard = new SamsungKeyboard();
			break;
		// 2. IBM컴퓨터에 사용될 IBM 키보드 추가 필요....
		case "IBM":
			keyboard = new IBMKeyboard();
			break;
		}
		return keyboard;
	}
}

//마우스
interface Mouse {
}

class LGMouse implements Mouse {
	public LGMouse() {
		System.out.println("LG 마우스 생성");
	}
}

class SamsungMouse implements Mouse {
	public SamsungMouse() {
		System.out.println("Samsung 마우스 생성");
	}
}

//2. IBM컴퓨터에 사용될 IBM 마우스 추가 필요....
class IBMMouse implements Mouse {
	public IBMMouse() {
		System.out.println("IBM 마우스 생성");
	}
}

//마우스 Factory
class MouseFactory {
	public Mouse createMouse(String type) {
		Mouse mouse = null;
		switch (type) {
		case "LG":
			mouse = new LGMouse();
			break;

		case "Samsung":
			mouse = new SamsungMouse();
			break;
		// 2. IBM컴퓨터에 사용될 IBM 마우스 추가 필요....
		case "IBM":
			mouse = new IBMMouse();
			break;
		}

		return mouse;
	}
}

//1.컴퓨터에 프린터가 추가 되어야 한다라고 가정했을 때 늘어나는 코드......
interface Printer {
}

class LGPrinter implements Printer {
	public LGPrinter() {
		System.out.println("LG 프린터 생성");
	}
}

class SamsungPrinter implements Printer {
	public SamsungPrinter() {
		System.out.println("Samsung 프린터 생성");
	}
}

//2. IBM컴퓨터에 사용될 IBM 프린터 추가 필요....
class IBMPrinter implements Printer {
	public IBMPrinter() {
		System.out.println("IBM 프린터 생성");
	}
}

class PrinterFactory {
	public Printer createPrinter(String type) {
		Printer printer = null;
		switch (type) {
		case "LG":
			printer = new LGPrinter();
			break;

		case "Samsung":
			printer = new SamsungPrinter();
			break;

		// 2. IBM컴퓨터에 사용될 IBM 프린터 추가 필요....
		case "IBM":
			printer = new IBMPrinter();
			break;
		}

		return printer;
	}
}
//1.컴퓨터에 프린터가 추가 되어야 한다라고 가정했을 때 늘어나는 코드......

//컴퓨터 Factory
class ComputerFactory {
	public Computer createComputer(String type) {

		Computer computer = new Computer();

		// 1. 컴퓨터에 프린터가 추가 되어야 한다라고 가정했을 때 늘어나는 코드......
		PrinterFactory printerFactory = new PrinterFactory();
		computer.setPrinter(printerFactory.createPrinter(type));

		KeyboardFactory keyboardFactory = new KeyboardFactory();
		computer.setKeyboard(keyboardFactory.createKeyboard(type));

		MouseFactory mouseFactory = new MouseFactory();
		computer.setMouse(mouseFactory.createMouse(type));

		return computer;
	}
}

class Computer {
	private Keyboard keyboard;
	private Mouse mouse;
	// 프린터 추가시
	private Printer printer;

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	// 프린터 추가시
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
