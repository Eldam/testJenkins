package es.uvigo.esei.daa.entities;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import java.sql.Time;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class UserUnitTest {
	@Test
	public void testUserIntStringStringStringStringStringDate() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(100);
		
		final User user = new User(id, login, password, name, surname, email, date);
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));
		
	}

	@Test(expected = NullPointerException.class)
	public void testUserIntStringStringStringStringStringDateNullLogin() {
		new User(1, null, "asdf", "Jon", "Doe", "falso@mail.com", new Date(100));
	}
	
	@Test(expected = NullPointerException.class)
	public void testUserIntStringStringStringStringStringDateNullPassword() {
		new User(1, "admin", null, "Jon", "Doe", "falso@mail.com", new Date(100));
	}

	@Test
	public void testSetLogin() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(1000000);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setLogin("normal");
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo("normal")));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));
	
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullLogin() {
		final User user = new User(1, "admin", "asdf", "Jon", "Doe", "falso@mail.com", new Date(100));
		
		user.setLogin(null);
	}
	
	@Test
	public void testSetPassword() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(1000000);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setPassword("qwert");
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo("qwert")));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullPassword() {
		final User user = new User(1, "admin", "asdf", "Jon", "Doe", "falso@mail.com", new Date(100));
		
		user.setPassword(null);
	}

	@Test
	public void testName() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(100);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setName("Juan");
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo("Juan")));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));	
		
	}

	@Test
	public void testSurname() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(100);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setSurname("Oed");
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo("Oed")));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));	
		
	}
	
	@Test
	public void testEmail() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(100);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setEmail("otro@gamil.com");
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo("otro@gamil.com")));
		assertThat(user.getInscriptionDate(), is(equalTo(date)));	
		
	}

	@Test
	public void testDate() {
		final int id = 1;
		final String login = "admin";
		final String password = "asdf";
		final String name = "John";
		final String surname = "Doe";
		final String email = "falso@mail.com";
		final Date date = new Date(100);
		
		final User user = new User(id, login, password, name, surname, email, date);
		user.setInscriptionDate(new Date(1000));
		
		assertThat(user.getId(), is(equalTo(id)));
		assertThat(user.getLogin(), is(equalTo(login)));
		assertThat(user.getPassword(), is(equalTo(password)));
		assertThat(user.getName(), is(equalTo(name)));
		assertThat(user.getSurname(), is(equalTo(surname)));
		assertThat(user.getEmail(), is(equalTo(email)));
		assertThat(user.getInscriptionDate(), is(equalTo(new Date(1000))));	
		
	}
	
	@Test
	public void testEqualsObject() {
		final User userA = new User(1, "admin", "asdf", "Jon", "Doe", "falso@mail.com", new Date(100));
		final User userB = new User(1, "ordinaryuser", "Lucas", "Lucas", "Doe", "lucas@mail.com", new Date(100));
		
		assertTrue(userA.equals(userB));
	}

	@Test
	public void testEqualsHashcode() {
		EqualsVerifier.forClass(User.class)
			.withPrefabValues(Date.class, new Date(1), new Date(2))
			.withIgnoredFields("login","password","name", "surname","email","inscription_date")
			.suppress(Warning.STRICT_INHERITANCE)
			.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}
}
