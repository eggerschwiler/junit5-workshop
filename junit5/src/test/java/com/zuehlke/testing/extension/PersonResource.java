package com.zuehlke.testing.extension;

import com.zuehlke.testing.Person;
import com.zuehlke.testing.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class PersonResource {

	private List<Person> people = new ArrayList<>();
	private PersonDao dao = new PersonDao();

	public Person createPerson(String name) {
		final Person person = new Person("", name);
		dao.save(person);
		people.add(person);
		return person;
	}

	void cleanUp() {
		for (Person person : people) {
			dao.delete(person);
		}
	}
}


