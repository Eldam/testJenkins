package es.uvigo.esei.daa.entities;

import static java.util.Objects.requireNonNull;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * An entity that represents an organizated event.
 * 
 * @author Victor Jose Malvarez Figueira
 * @author Brais Álvarez Fernández
 */

public class Event {
	private String name;
	private String description;
	private Date date;
	private Time time;
	private String category;
	private int id;
	private int maxInscriptions;
	private String location;
	
	
	@Override
	public String toString() {
		return "Event [name=" + name + ", description=" + description + ", date=" + date + ", time=" + time +", category=" + category + ", id="
				+ id + ", maxInscriptions=" + maxInscriptions + ", location=" + location + "]";
	}

	// Constructor needed for the JSON conversion
	Event() {}
	
	/**
	 * Constructs a new instance of {@link Event}.
	 *
	 * @param id id that identifies the event in the system.
	 * @param name name of the event.
	 * @param description description that explains in which the event consists
	 * @param date date {@code Date} when the event occurs.
	 * @param time time {@code Time} when the event starts.
	 * @param category string with the category of the event
	 * @param maxInscriptions maxInscriptions total number of inscriptions available for this event
	 * @param location location geographical place where the event will be celebrated
	 * 
	 * @throws IllegalArgumentException if the {@code id} is a non positive number.
	 */
	public Event(int id,String name, String description, Date date, Time time, String category, int maxInscriptions, String location) throws IllegalArgumentException {
		if(id < 1) throw new IllegalArgumentException("It must be a positive number");
		this.id= id;
		this.setName(name);
		this.setDescription(description);
		this.setDate(date);
		this.setTime(time);
		this.setCategory(category);
		this.setMaxInscriptions(maxInscriptions);
		this.setLocation(location);
	}

	/**
	 * Returns the identifier of the event.
	 * 
	 * @return the identifier of the event.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the event.
	 * 
	 * @return the name of the event.
	 */	
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this event.
	 * 
	 * @param name the new name of the event.
	 * @throws NullPointerException if the {@code name} is {@code null}.
	 */
	public void setName(String name) {
		this.name = requireNonNull(name,"The name of the event can't be null");
	}

	/**
	 * Returns the date when the event occurs.
	 * 
	 * @return a {@code Date} when the event occurs.
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Set the date of the event.
	 * 
	 * @param date the new {@code Date} for the event.
	 */
	public void setDate(Date date) {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			String formatedDate = format.format(date);
			java.util.Date dateWithoutTime = format.parse(formatedDate);
			
			this.date = new Date(dateWithoutTime.getTime());
		} catch (ParseException e) {
			throw new IllegalStateException("Unexpected exception", e);
		}
	}

	/**
	 * Returns the description of the event
	 * 
	 * @return the description of the event
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of this event.
	 * 
	 * @param description the new description of the event.
	 * @throws NullPointerException if the {@code description} is {@code null}.
	 */
	public void setDescription(String description) {
		this.description = requireNonNull(description,"Description can't be null");
	}

	/**
	 * Returns the time when the event starts
	 * 
	 * @return time {@code Time} of the event
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Set the time when the event starts
	 * 
	 * @param time {@code Time} the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * Returns the category of the event
	 * 
	 * @return the category of the event
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the category of this event.
	 * 
	 * @param category the new category of the event.
	 * @throws NullPointerException if the {@code category} is {@code null}.
	 */
	public void setCategory(String category) {
		this.category = requireNonNull(category,"Category can't be null");
	}
	
	/**
	 * Returns the maxInscriptions of the event
	 * 
	 * @return the maxInscriptions of the event
	 */
	public int getMaxInscriptions() {
		return maxInscriptions;
	}

	/**
	 * Set the maxInscriptions of this event.
	 * 
	 * @param maxInscriptions the new inscriptions of the event.
	 * @throws IllegalArgumentException if the {@code maxInscriptions} is a number equal or below 0.
	 */
	public void setMaxInscriptions(int maxInscriptions) throws IllegalArgumentException{
		if (maxInscriptions <= 0){
			throw new IllegalArgumentException("Number of maximum inscriptions must be over 0");
		}
		this.maxInscriptions = maxInscriptions;
	}
	
	/**
	 * Returns the location of the event
	 * 
	 * @return the location of the event
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the location of this event.
	 * 
	 * @param location the new category of the event.
	 * @throws NullPointerException if the {@code category} is {@code null}.
	 */
	public void setLocation(String location) {
		this.location = requireNonNull(location,"Location can't be null");
	}

	
	@Override
	public int hashCode() {
		final int prime = 33;
		int result = 2;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Event))
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
