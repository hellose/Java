package optional;

import java.util.Optional;

public class Basic2 {

	public static void main(String[] args) {

		Optional<String> stringOptional = Optional.ofNullable(null);

		String alternativeString = "hello";
		// orElst -> 미리 생성된 객체를 이용
		String result1 = stringOptional.orElse(alternativeString);
		System.out.println(result1);

		// orElseGet -> Supplier를 통해 생성된 객체를 이용
		String result2 = stringOptional.orElseGet(() -> "hi");
		System.out.println(result2);
	}

}
