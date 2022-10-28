package annotation.readme;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target 어노테이션의 목적 -> 특정 어노테이션이 사용될 수 있는 곳을 제한
//어노테이션을 적용할 수 있는 곳 java.lang.annotation.ElementType 열거형에 정의되어 있다

//@Target(value = {ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE})

// value 엘리먼트이기 때문에 생략 가능
//@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE })

//@Target 어노테이션의 value 엘레먼트의 타입이 Element[]이므로 value를 생략할 수 있는 것임
//@Target 어노테이션을 붙이지 않음 -> 모든 곳에 사용가능

//@Target({ElementType.FIELD})로 하나이면 { } 생략가능
//@Target(ElementType.FIELD)

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE })
@interface Test {
}

@Test // TYPE
class TestClass {

	@Test // FIELD
	private String field;

	@Test // METHOD
	private static void sMethod() {
	}

	@Test // METHOD
	private void method() {
		@Test // LOCAL_VARIABLE
		int i;
	}

	@Test // CONSTRUCTOR
	private TestClass() {
	}
}