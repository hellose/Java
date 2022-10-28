package annotation.readme;

//어노테이션 정의 -> @interface 어노테이션명 -> 정의된 어노테이션 사용 -> @어노테이션명으로 사용할 수 있다.
@interface CustomAnnotationTest {
	// 엘리먼트 정의 - 타입 elementName() [default 값];

	// elementName1은 default값이 없으므로 반드시 기술해야 함
	String element1();

	// elementName2는 default값이 존재하기 때문에 생략 가능하다.
	int element2() default 5;
}
//사용
//@CustomAnnotation1(element1="값", element2=3);
//@CustomAnnotation1(element1="값");




@interface CustomAnnotationTest2 {
	// 기본 element value -> 엘리먼트 이름 없이 값만 기술할 경우 -> 이 값은 자동으로 value엘리먼트로 설정된다.
	String value();
}
//사용
//@CustomAnnotationTest2("값");