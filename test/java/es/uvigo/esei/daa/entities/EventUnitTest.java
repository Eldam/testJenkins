package es.uvigo.esei.daa.entities;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class EventUnitTest {
	
	public Date normalizeDate(Date normalizedate) {
	final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	try {
		String formatedDate = format.format(normalizedate);
		java.util.Date dateWithoutTime = format.parse(formatedDate);
		
		return new Date(dateWithoutTime.getTime());
		
	} catch (ParseException e) {
			throw new IllegalStateException("Unexpected exception", e);
		}
	}
	
	@Test
	public void testEventIntStringStringDateTimeStringIntString() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
	
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions,location);
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
		
	}

	@Test(expected = NullPointerException.class)
	public void testEventIntStringStringDateTimeStringIntStringNullName() {
		new Event(1, "aaaa", "This is the description of the event", new Date(100), new Time(100),"Deportes", 777, "Puente Romano, Ourense");
	}
	
	@Test(expected = NullPointerException.class)
	public void testEventIntStringStringStringDateTimeStringIntStringNullDescripton() {
		new Event(1, "Event 1", null, new Date(100), new Time(100),"Deportes", 777, "Puente Romano, Ourense");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEventIntStringStringDateTimeStringIntStringNegativeId() {
		new Event(-1, "Event 1", "This is the description of the event" , new Date(100), new Time(100),"Deportes", 777, "Puente Romano, Ourense");
	}

	@Test(expected = NullPointerException.class)
	public void testEventIntStringStringDateTimeStringIntStringNullCategory() {
		new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100),null, 777, "Puente Romano, Ourense");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEventIntStringStringDateTimeStringIntStringNegativeMaxInscriptions() {
		new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100),"Deportes", -777, "Puente Romano, Ourense");
	}

	@Test(expected = NullPointerException.class)
	public void testEventIntStringStringDateTimeStringIntStringNullLocation() {
		new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100),null, 777, null);
	}
	
	@Test
	public void testSetName() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);
		event.setName("Event 2");
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo("Event 2")));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
		
	
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullName() {
		final Event event = new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100),"Deportes", 777, "Puente Romano, Ourense");
		
		event.setName(null);
	}

	
	@Test
	public void testSetDescription() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);
		event.setDescription("Description modified");
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo("Description modified")));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
	
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullDescription() {
		final Event event = new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100), "Deportes", 777, "Puente Romano, Ourense");
		
		event.setDescription(null);
	}

	@Test
	public void testSetDate() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);		event.setDate(new Date(2000));
		event.setDate(new Date(2000));
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(new Date(2000)))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
	
	}
	
	@Test
	public void testSetTime() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);		event.setTime(new Time(2000));
		event.setTime(new Time(2000));
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(new Time(2000))));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
	
	}
	
	@Test
	public void testSetCategory() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);		event.setCategory("Literatura");
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo("Literatura")));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo(location)));
	
	}
	

	@Test
	public void testSetMaxInscriptions() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);
		event.setMaxInscriptions(17);
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(17)));
		assertThat(event.getLocation(), is(equalTo(location)));
	
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeMaxInscription() {
		final Event event = new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100), "Deportes", 777, "Puente Romano, Ourense");
		
		event.setMaxInscriptions(-32);
	}
	
	@Test
	public void testSetLocation() {
		final int id = 1;
		final String name = "Event 1";
		final String description = "This is the description of the event";
		final Date date = new Date(100);
		final Time time = new Time(100);
		final String category = "Deportes";
		final int maxInscriptions = 777;
		final String location = "Puente Romano, Ourense";
		
		final Event event = new Event(id, name, description, date, time, category, maxInscriptions, location);
		event.setLocation("Location modified");
		
		assertThat(event.getId(), is(equalTo(id)));
		assertThat(event.getName(), is(equalTo(name)));
		assertThat(event.getDescription(), is(equalTo(description)));
		assertThat(event.getDate(), is(equalTo(normalizeDate(date))));
		assertThat(event.getTime(), is(equalTo(time)));
		assertThat(event.getCategory(), is(equalTo(category)));
		assertThat(event.getMaxInscriptions(), is(equalTo(maxInscriptions)));
		assertThat(event.getLocation(), is(equalTo("Location modified")));
	
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullLocation() {
		final Event event = new Event(1, "Event 1", "This is the description of the event" , new Date(100), new Time(100), "Deportes", 777, "Puente Romano, Ourense");
		
		event.setLocation(null);
	}
	
	@Test
	public void testEqualsObject() {
		final Event eventA = new Event(1, "Event 1", "This is the description of the event 1" , new Date(100), new Time(100),"Deportes",777, "Puente Romano, Ourense");
		final Event eventB = new Event(1, "Event 2", "This is the description of the event 2" , new Date(100), new Time(100),"Deportes", 777, "Puente Romano, Ourense");
		
		assertTrue(eventA.equals(eventB));
	}

	@Test
	public void testEqualsHashcode() {
		EqualsVerifier.forClass(Event.class)
			.withPrefabValues(Date.class, new Date(1), new Date(2))
			.withPrefabValues(Time.class, new Time(1), new Time(2))
			.withIgnoredFields("name", "description","date","time","category","maxInscriptions","location")
			.suppress(Warning.STRICT_INHERITANCE)
			.suppress(Warning.NONFINAL_FIELDS)

		.verify();
	}
}
