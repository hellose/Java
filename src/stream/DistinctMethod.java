package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctMethod {

	private static class Student {

		private int id;

		public Student(int id) {
			super();
			this.id = id;
		}

		public int getId() {
			return id;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return id == other.id;
		}

	}

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student(1));
		students.add(new Student(2));
		students.add(new Student(1));
		students.add(new Student(2));

		Stream<Student> stream = students.stream();
		// �߰� ����. distinct�� �Ǵ��� Object�� equals()�� hashCode()�� ���� �Ǵܵ�
		Stream<Student> distinctStream = stream.distinct();
		// ���� ����
		List<Student> distinctStudents = distinctStream.collect(Collectors.toList());

		// forEach�� ���� Consumer
		Consumer<Student> studentConsumer = student -> System.out.println(student.getId());

		students.forEach(studentConsumer);
		System.out.println();
		distinctStudents.forEach(studentConsumer);

	}

}
