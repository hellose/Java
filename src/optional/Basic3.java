package optional;

import java.util.Optional;
import java.util.function.Function;

public class Basic3 {

	public static void main(String[] args) {

		User user1 = new User(new Address(null));
		User user2 = new User(new Address("131-187"));

		System.out.println(beforeUseOptional(user1));
		System.out.println(beforeUseOptional(user2));
		System.out.println();

		System.out.println(afterUseOptional1(user1));
		System.out.println(afterUseOptional1(user2));
		System.out.println();

		System.out.println(afterUseOptinal2(user1));
		System.out.println(afterUseOptinal2(user2));
		System.out.println();
	}

	private static class User {
		private Address address;

		public User(Address address) {
			super();
			this.address = address;
		}

		public Address getAddress() {
			return address;
		}
	}

	private static class Address {
		private String postCode;

		public Address(String postCode) {
			super();
			this.postCode = postCode;
		}

		public String getPostCode() {
			return postCode;
		}
	}

	// Optional 사용 전 (if문의 null체크 로직으로 인해 불필요한 타이핑이 생김)
	public static String beforeUseOptional(User user) {
		String alternativeString = "";
		if (user == null) {
			return alternativeString;
		}
		if (user.getAddress() == null) {
			return alternativeString;
		}
		if (user.getAddress().getPostCode() == null) {
			return alternativeString;
		}
		return user.getAddress().getPostCode();
	}

	// Optional 사용 1
	public static String afterUseOptional1(User user) {
		Optional<User> userOp = Optional.ofNullable(user);

		Function<User, Address> userToAddress = u -> u.getAddress();
		Optional<Address> addressOp = userOp.map(userToAddress);
		// userOp.map 호출시
		// 1. userOp의 User가 null이면 Address타입 Optional인 EMPTY 재활용(Address타입 형변환)
		// userOp의 User가 null이 아니면 -> userToAddress함수 적용
		// 2. userToAddress 함수의 결과가 null -> EMPTY 재활용(Optional<Address>)
		// userToAddress 함수의 결과가 null이 아니면 -> of(함수 결과)로 Optional<Address> 생성

		Function<Address, String> addressToPostCode = a -> a.getPostCode();
		Optional<String> postCodeOp = addressOp.map(addressToPostCode);

		return postCodeOp.orElseGet(() -> "null임");
	}

	// Optional 사용 2
	public static String afterUseOptinal2(User user) {
		return Optional.ofNullable(user).map(User::getAddress).map(Address::getPostCode).orElseGet(() -> "값 없음");
	}
}
