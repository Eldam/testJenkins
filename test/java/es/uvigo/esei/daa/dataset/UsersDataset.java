package es.uvigo.esei.daa.dataset;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import es.uvigo.esei.daa.entities.User;

public final class UsersDataset {
	private UsersDataset() {}

	public static User[] users() {
		return new User[] {
			new User(1, adminLogin(), "2bdc94a3ae40227246a17831b833ba9047b4ff2778180b1a1c0c303e248e574e", "Antonio", "González", "Antonio@email.com", adminDate()),
			new User(2, normalLogin(), "905d5c1331987f8670ff86955788628bda62ea165cc4c2c5b44b6402b669274d", "Marco Aurelio", "González", "marco@email.com", userDate())
		};
	}
	
	public static User user(String login) {
		return Arrays.stream(users())
			.filter(user -> user.getLogin().equals(login))
			.findAny()
		.orElseThrow(IllegalArgumentException::new);
	}
	
	public static String adminLogin() {
		return "admin";
	}
	
	public static String normalLogin() {
		return "marco";
	}
	
	public static Date adminDate(){
		String str_date = "2018-01-01 01:00:00";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		
		try{
			date = formatter.parse(str_date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static Date userDate(){
		String str_date = "2018-01-02 01:00:00";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		
		try{
			date = formatter.parse(str_date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String userToken(String login) {
		final String chain = login + ":" + login + "pass";
		
		return Base64.getEncoder().encodeToString(chain.getBytes());
	}
}