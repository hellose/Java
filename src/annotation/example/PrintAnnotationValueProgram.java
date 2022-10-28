package annotation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//어노테이션에 해당하는 값 출력
class PrintAnnotationValueProgram {
	public static void main(String[] args) {
		Method[] declareMethods = PrintAnnotationValueProgram.class.getDeclaredMethods();
		for (Method method : declareMethods) {
			System.out.println("Method Name: " + method.getName());
			// 메서드에 Anno 어노테이션이 존재하는지 확인
			if (method.isAnnotationPresent(Anno.class)) {
				System.out.println("Anno 어노테이션 붙음");
				// 메서드에 부착된 Anno 어노테이션 객체 얻기
				Anno anno = method.getAnnotation(Anno.class);

				System.out.println("value: " + anno.value());
				System.out.println("element2: " + anno.element2());
			} else {
				System.out.println("Anno 어노테이션 안붙음");
			}
			System.out.println();
		}
	}

	@Anno(value = "테스트", element2 = 3)
	public void attachedMethod() {

	}
}

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
//RUNTIME으로 설정해야 런타임에 어노테이션 정보를 얻을 수 있다.
@interface Anno {
	String value();

	int element2();
}
