package innerAndNestedClass;

class Program {

	public static void main(String[] args) {

	}

}

//TestClass에서는 바로 하위인 FirstLevel는 TestClass.FirstLevel에서 TestClass 생략가능
//SecondLevel을 참조하기 위해서는 FirstLevel.SecondLevel을 사용해야 한다.
class TestClass {

	private static class FirstLevel {
		private static class SecondLevel {
		}
	}

	private static final FirstLevel first = new FirstLevel();
	private static final FirstLevel.SecondLevel second = new FirstLevel.SecondLevel(); // new SecondLevel(); //에러

	// = TestClass.FirstLevel getFirstLevelInstance(){
	FirstLevel getFirstLevelInstance() {
		return first;
	}

	// SecondLevel getSecondLevelInstance(){ //에러.
	// = TestClass.FirstLevel.SecondLevel getSecondLevelInstance(){
	FirstLevel.SecondLevel getSecondLevelInstance() {
		return second;
	}

}
