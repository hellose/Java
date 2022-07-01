package optional;

import java.util.Optional;

public class Program2 {

	public static void main(String[] args) {

		User user1 = new User(new Address(null));
		User user2 = new User(new Address("131-187"));

		System.out.println(beforeUseOptional(user1));
		System.out.println(beforeUseOptional(user2));
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
	
	//Optional 사용 전
	public static String beforeUseOptional(User user) {
		String alternativeString = "�����ȣ ����";
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
	
	//TODO
	//Optional 사용 후
	public static void afterUseOptional(User user) {
		Optional<User> optionalUser = Optional.ofNullable(user);

	}
}
