package annotation.typeAndAnnotationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Anno
class Test {

}

@Anno
@interface TestAnno {

}

@Anno
interface TestInter {

}

//@Target(ElementType.ANNOTATION_TYPE)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface Anno {

}
