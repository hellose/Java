package designpattern.factory.abstractfactory.afteruse;

//출처 
//https://victorydntmd.tistory.com/300
//https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile9.uf.tistory.com%2Fimage%2F995759355E34E9DE086856

//추상 팩토리 패턴을 활용한 경우
class Program {

	public static void main(String[] args) {
		ComputerFactory computerFactory = new SelectFactoryClass().selectComputerFactory("LG");
		Computer computer = computerFactory.createComputer();
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

class Computer {
	private Keyboard keyboard;
	private Mouse mouse;

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
}

//추상 컴퓨터 Factory
interface ComputerFactory {
	public Computer createComputer();
}

//LG 컴퓨터 Factory
class LGComputerFactory implements ComputerFactory {
	public Computer createComputer() {
		Computer computer = new Computer();
		computer.setMouse(new LGMouse());
		computer.setKeyboard(new LGKeyboard());
		return computer;
	}
}

//Samsung 컴퓨터 Factory
class SamsungComputerFactory implements ComputerFactory {
	public Computer createComputer() {
		Computer computer = new Computer();
		computer.setMouse(new SamsungMouse());
		computer.setKeyboard(new SamsungKeyboard());
		return computer;
	}
}

//컴퓨터 Factory 객체를 생성하는 선택 클래스
class SelectFactoryClass {
	public ComputerFactory selectComputerFactory(String type) {
		switch (type) {
		case "LG":
			return new LGComputerFactory();
		case "Samsung":
			return new SamsungComputerFactory();
		default:
			return null;
		}
	}
}
