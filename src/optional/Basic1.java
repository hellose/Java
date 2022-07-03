package optional;

import java.util.Optional;

public class Basic1 {

	public static void main(String[] args) {

		// random int 1~10
		int i = ((int) (Math.random() * 10)) + 1;

		String nullableString;
		if (i <= 5) {
			nullableString = null;
		} else {
			nullableString = "Hello";
		}

		String alternativeString = "hi";

		Optional<String> stringOptional = Optional.ofNullable(nullableString);
		if (stringOptional.isPresent()) {
			// get()메서드는 내부 필드가 null이면 NoSuchElementException이 발생
			// isPresent()를 통해 체크 후 호출해야함
			System.out.println(stringOptional.get());
		} else {
			System.out.println(alternativeString);
		}

	}

}
