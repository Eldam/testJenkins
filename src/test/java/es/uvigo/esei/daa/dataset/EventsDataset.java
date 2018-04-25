package es.uvigo.esei.daa.dataset;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.sql.Date;
import java.sql.Time;
import java.util.function.Predicate;

import es.uvigo.esei.daa.entities.Event;

public final class EventsDataset {
	private EventsDataset() {}
	
	public static Event[] events() {
		return new Event[] {
			new Event(1, "Cineforum American Beauty", "Discusión sobre la película", CustomizedDate("2018-01-01"), CustomizedTime("01:00:00"), "Cine", 23, "Ponte Vella, Ourense"),
			new Event(2, "Cineforum American history X", "Discusión sobre la película", CustomizedDate("2018-02-02"), CustomizedTime("02:00:00"),"Cine", 45, "Ponte Vella, Ourense"),
			new Event(3, "Lectura de libro Las Dos Torres", "Lectura de trozos del libro por distintas personalidades", CustomizedDate("2018-03-03"), CustomizedTime("03:00:00"),"Literatura", 60, "Biblioteca Municiapl, Ourense"),
			new Event(4, "Visionado de partido LFP", "Reunión para ver el partido Levante-Leganés", CustomizedDate("2018-04-04"), CustomizedTime("04:00:00"),"Deportes", 50, "Bar Eurosport, Ourense"),
			new Event(5, "Reunión de antiguos alumnos", "Una reunión de reencuentro", CustomizedDate("2018-05-05"), CustomizedTime("05:00:00"),"Otros", 62, "ESEI, Ourense")
		};
	}
	
	public static Event[] searchedEvents() {
		return new Event[] {
			new Event(1, "Cineforum American Beauty", "Discusión sobre la película", CustomizedDate("2018-01-01"), CustomizedTime("01:00:00"), "Cine", 23, "Ponte Vella, Ourense"),
			new Event(2, "Cineforum American history X", "Discusión sobre la película", CustomizedDate("2018-02-02"), CustomizedTime("02:00:00"),"Cine", 45, "Ponte Vella, Ourense"),
		};
	}
	
	public static Event[] advancedSearchedEvents() {
		return new Event[] {
			new Event(2, "Cineforum American history X", "Discusión sobre la película", CustomizedDate("2018-02-02"), CustomizedTime("02:00:00"),"Cine", 45, "Ponte Vella, Ourense"),
		};
	}
	
	public static Event[] eventsWithout(int ... ids) {
		Arrays.sort(ids);
		
		final Predicate<Event> hasValidId = event ->
			binarySearch(ids, event.getId()) < 0;
		
		return stream(events())
			.filter(hasValidId)
		.toArray(Event[]::new);
	}
	
	public static Event event(int id) {
		return stream(events())
			.filter(event -> event.getId() == id)
			.findAny()
		.orElseThrow(IllegalArgumentException::new);
	}
		
	public static Date CustomizedDate(String customDate){
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date date = null;
		
		try{			
			date = new Date(formatter.parse(customDate + " 00:00:00").getTime());
			
		}
		catch(ParseException e){
			e.printStackTrace();
		}

		return date;
	}
	
	public static Time CustomizedTime(String customTime){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Time time = null;
		
		try{
			time = new Time(formatter.parse(customTime).getTime());
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
		return time;
	}

	public static int existentId() {
		return 2;
	}
	
	public static int nonExistentId() {
		return 1234;
	}

	public static String existenCategory() {
		return "Cine";
	}
	
	public static String nonExistenCategory() {
		return "Lucha grecorromana";
	}
	
	
	public static Event existentEvent() {
		return event(existentId());
	}
	
	public static Event nonExistentEvent() {
		return new Event(nonExistentId(), "Cata de vinos albariño", "El nombre lo dice todo", CustomizedDate("2018-05-05"), CustomizedTime("05:00"), existenCategory(), newMaxInscriptions(), newLocation());
	}
	
	
	public static String newName() {
		return "Ringo";
	}
	
	public static String newDescription() {
		return "Descripción Random";
	}
	
	public static Date newDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		Date sqlDate = null;
		try{
			date = formatter.parse("2018-02-02");
			sqlDate = new Date(date.getTime());
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
		return sqlDate;
	}
	
	public static Time newTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		java.util.Date time = null;
		Time sqlTime = null;
		
		try{
			time = formatter.parse("19:15:00");
			sqlTime = new Time(time.getTime());
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
		return sqlTime;
	}

	public static String newSearch() {
		return "American";
	}
	
	public static int newMaxInscriptions(){
		return 69;
	}
	
	public static String newLocation(){
		return "Route 66, Ourense";
	}
	
	public static Event newEvent() {
		return new Event(events().length + 1, newName(), newDescription(), newDate(), newTime(), existenCategory(), newMaxInscriptions(), newLocation());
	}
}
