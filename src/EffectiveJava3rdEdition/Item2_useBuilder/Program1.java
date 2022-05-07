package EffectiveJava3rdEdition.Item2_useBuilder;

//중첩 클래스가 이해되지 않을 때 package innerAndNestedClass 참고

//1. 생성자가 다양한 경우 생성자를 통해 인스턴스를 잘못 생성할 가능성이 존재
//2. 자바빈을 통해 필드 setter메서드를 사용해 필드 값 주입시 객체의 불변성이 유지되지 못하게 된다.
//3. Builder Pattern 사용 (필드가 변경되는 경우 static 내부 클래스의 필드도 변경되어야 하는 문제 발생)

class Program1 {

	public static void main(String[] args) {

		Product.Builder builder = new Product.Builder("과자", "도리토스 작은봉지");
		Product product = builder.price(2000).calorty(400).build();
		System.out.println("product- " + product.toString());

		Product product2 = builder.name("도리토스 큰봉지").price(4000).calorty(1000).build(); // Product.Builder 객체 재활용
		System.out.println("product2- " + product2.toString());

		// Product product3 = new Product(builder);

	}

}

class Product {
	private String type;
	private String name;
	private int price;
	private int calory;

	// private -> instance only created by Builder.build();
	private Product(Builder builder) {
		this.type = builder.type; 
		this.name = builder.name;
		this.price = builder.price;
		this.calory = builder.calory;
	}

	// 외부 인스턴스 필요없어야 해서 static 클래스 필요
	// private일 경우 클래스를 Product 클래스 내부에서만 사용가능하기 때문에 이보다 넓은 범위 사용
	static class Builder {
		private String type; // 필수
		private String name; // 필수
		private int price;
		private int calory;

		Builder(String type, String name) {
			this.type = type;
			this.name = name;
		}

		Builder type(String type) { // 필수 필드 변경
			this.type = type;
			return this;
		}

		Builder name(String name) { // 필수 필드 변경
			this.name = name;
			return this;
		}

		Builder price(int price) { // 선택 필드 변경
			this.price = price;
			return this;
		}

		Builder calorty(int calory) { // 선택 필드 변경
			this.calory = calory;
			return this;
		}

		Product build() { // 빌더인스턴스.build();
			return new Product(this);
		}

	}

	public String toString() {
		return "type: " + type + ",name: " + name + ", price: " + price + ", calory: " + calory;
	}
}
