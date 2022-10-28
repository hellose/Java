package string;

//16진수 00~FF는 256개의 값으로 byte 타입으로 충당가능 
//byte타입은 -128~127이므로 테스트하여 결과값 확인
public class MacAddressTest {

	public static void main(String[] args) {

		System.out.println("Mac 주소 확인 테스트 -128부터 127까지");

		byte testByte = Byte.MIN_VALUE;
		while (testByte != Byte.MAX_VALUE) {
			System.out.println("byte: " + testByte + " => mac: " + String.format("%02X", testByte));
			testByte = (byte) (testByte + 1);
		}
		System.out.println();
	}

}
