package thisKeywordInAbstract;

abstract class AbsClass {
	private String clsName = this.getClass().getName();

	AbsClass() {
		super();
	}

	public void print() {
		System.out.println(this.clsName);
	}
}
