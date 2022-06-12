package gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

//Java객체를 JSON에 추가
public class Program2 {

	public static void main(String[] args) {
		Gson gson = new Gson();

		Person person = new Person("김", 10);

		JsonElement el1 = gson.toJsonTree(person);
		// {"name":"김","age":10}
		System.out.println(el1);
		System.out.println();

		List<Person> persons = new ArrayList<>();
		Person person2 = new Person("이", 20);
		persons.add(person);
		persons.add(person2);

		JsonElement el2 = gson.toJsonTree(persons);
		// [{"name":"김","age":10},{"name":"이","age":20}]
		System.out.println(el2);
		System.out.println();
	}

}
