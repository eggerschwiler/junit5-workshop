package com.zuehlke.testing.extension;

import com.zuehlke.testing.Person;
import com.zuehlke.testing.PersonDao;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Collection;
import java.util.LinkedList;

public class PersonResource implements AfterEachCallback {

	private PersonDao dao = new PersonDao();
	private Collection<Person> people = new LinkedList<>();

	Person createPerson(String name) {
		final Person person = new Person("", name);
		dao.save(person);
		people.add(person);
		return person;
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		for (Person person : people) {
			dao.delete(person);
		}
	}
}


