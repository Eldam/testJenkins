package es.uvigo.esei.daa.entities;

import static java.util.Objects.requireNonNull;

import java.util.Date;

/**
 * An entity that represents a user.
 * 
 * @author Victor Jose Malvarez Figueira
 * @author Brais Álvarez Fernández
 */
public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private Date inscription_date;
	private int id;
	
	
	// Constructor needed for the JSON conversion
	User() {}
	
	/**
	 * Constructs a new instance of {@link User}.
	 *
	 * @param login login that identifies the user in the system.
	 * @param password password of the user encoded using SHA-256 and with the
	 * "salt" prefix added.
	 */
	public User(int id, String login, String password, String name, String surname, String email, Date inscription_date) throws IllegalArgumentException {
		if(id < 1) throw new IllegalArgumentException("It must be a positive number");
		this.id = id;
		this.setLogin(login);
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setInscriptionDate(inscription_date);
	}

	
	/**
	 * Returns the identifier of the user.
	 * 
	 * @return the identifier of the user.
	 */
	public int getId() {
		return id;
	}


	/**
	 * Returns the name of the user.
	 * 
	 * @return the name of the user.
	 */	
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this user.
	 * 
	 * @param name the new name of the user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the surname of the user.
	 * 
	 * @return the surname of the user.
	 */	
	public String getSurname() {
		return surname;
	}

	/**
	 * Set the surname of this user.
	 * 
	 * @param surname the new surname of the user.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Returns the email of the user.
	 * 
	 * @return the email of the user.
	 */	
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of this user.
	 * 
	 * @param email the new email of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the inscription_date of the user.
	 * 
	 * @return inscription_date {@code Date} the inscription of the user.
	 */	
	public Date getInscriptionDate() {
		return inscription_date;
	}

	/**
	 * Set the inscription_date of this user.
	 * 
	 * @param date {@code Date} the new inscription_date of the user.
	 */
	public void setInscriptionDate(Date inscription_date) {
		this.inscription_date = inscription_date;
	}



	/**
	 * Returns the login of the user.
	 * 
	 * @return the login of the user.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login of the user.
	 * 
	 * @param login the login that identifies the user in the system.
	 */
	public void setLogin(String login) {
		this.login = requireNonNull(login, "Login can't be null");
	}
	
	/**
	 * Returns the password of the user.
	 * 
	 * @return the password of the user.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the users password.
	 * @param password the password of the user
	 */
	public void setPassword(String password) {
		requireNonNull(password, "Password can't be null");

		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}