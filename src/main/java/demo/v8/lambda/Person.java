package demo.v8.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	public Person(String name, Sex gender, String emailAddress, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.age = age;
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	int age;

	public int getAge() {
		return age;
	}

	public void printPerson() {
		System.out.println(String.format("{name:%s, age:%s, gender:%s}", name, age, gender));
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public static List<Person> createRoster() {
		List<Person> ps = new ArrayList<Person>();
		int x = 0;
		for (String name : ns) {
			Person p = new Person(name, Sex.values()[x%2], name+"@xx.net", new Random().nextInt(120));
			ps.add(p);
			x++;
		}
		return ps;
	}
	
	private static String[] ns = new String[]{
			"Noah",	
			"Emma",
			"Liam",	
			"Olivia",
			"Mason",	
			"Sophia",
			"Jacob",	
			"Isabella",
			"William",	
			"Ava",
			"Ethan",	
			"Mia",
			"Michael",	
			"Emily",
			"Alexander",
			"Abigail",
			"James",	
			"Madison",
			"Daniel",	
			"Charlotte"
			};
	
}
