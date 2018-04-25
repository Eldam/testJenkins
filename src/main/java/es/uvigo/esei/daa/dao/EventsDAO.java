package es.uvigo.esei.daa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.uvigo.esei.daa.entities.Event;

public class EventsDAO extends DAO{
	private final static Logger LOG = Logger.getLogger(EventsDAO.class.getName());
	
	/**
	 * Returns a list with all the events persisted in the system.
	 * 
	 * @return a list with all the events persisted in the system.
	 * @throws DAOException if an error happens while retrieving the events.
	 */
	public List<Event> list() throws DAOException {
		try (final Connection conn = this.getConnection()) {
			final String query = "SELECT * FROM event";
			
			try (final PreparedStatement statement = conn.prepareStatement(query)) {
				try (final ResultSet result = statement.executeQuery()) {
					final List<Event> events = new LinkedList<>();
					
					while (result.next()) {
						events.add(rowToEntity(result));
					}
					
					return events;
				}
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Error listing events", e);
			throw new DAOException(e);
		}
	}
	
	
	/**
	 * Returns a event stored persisted in the system.
	 * 
	 * @param id identifier of the event.
	 * @return a event with the provided identifier.
	 * @throws DAOException if an error happens while retrieving the event.
	 * @throws IllegalArgumentException if the provided id does not corresponds
	 * with any persisted event.
	 */
	public Event get(int id)
	throws DAOException, IllegalArgumentException {
		try (final Connection conn = this.getConnection()) {
			final String query = "SELECT * FROM event WHERE id=?";
			
			try (final PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setInt(1, id);
				
				try (final ResultSet result = statement.executeQuery()) {
					if (result.next()) {
						return rowToEntity(result);
					} else {
						throw new IllegalArgumentException("Invalid id");
					}
				}
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Error getting a event", e);
			throw new DAOException(e);
		}
	}
	
	
	/**
	 * Returns a event stored persisted in the system.
	 * 
	 * @param id identifier of the event.
	 * @return a event with the provided identifier.
	 * @throws DAOException if an error happens while retrieving the event.
	 * @throws IllegalArgumentException if the provided id does not corresponds
	 * with any persisted event.
	 */
	public List<Event>  getByWord(String search)
	throws DAOException, IllegalArgumentException {
		try (final Connection conn = this.getConnection()) {
			final String query = "SELECT * FROM event WHERE description LIKE ? "
					+ "OR name LIKE ?";
			
			try (final PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setString(1, "%" + search + "%");
				statement.setString(2, "%" + search + "%");
				
				try (final ResultSet result = statement.executeQuery()) {
					final List<Event> events = new LinkedList<>();
					
					while (result.next()) {
						events.add(rowToEntity(result));
					}
					return events;
				}
				
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Error searching events", e);
			throw new DAOException(e);
		}
	}
	
	
	/**
	 * Returns a event stored persisted in the system.
	 * 
	 * @param category category of the event.
	 * @return a list of events with the provided category.
	 * @throws DAOException if an error happens while retrieving the event.
	 * @throws IllegalArgumentException if the provided category does not corresponds
	 * with any persisted event.
	 */
	public List<Event> advancedSearch(String category, String date, String order)
	throws DAOException, IllegalArgumentException {
		try (final Connection conn = this.getConnection()) {
			String query = "";
			if (date.equals("none")) {
				query = "SELECT * FROM event WHERE category LIKE ?";
			} else {
				query = "SELECT * FROM event WHERE category LIKE ? AND date = ?";
			}

			if (!order.equals("none")) {
				query += " ORDER BY " + order + " ASC";
			}
			
			System.out.println("Cat: "+ category+"\nDat: "+date+"\nOrder: "+order);
			System.out.println(query);
			try (final PreparedStatement statement = conn.prepareStatement(query)) {
				if (category.equals("all")) {
					statement.setString(1, "%%");
				} else {
					statement.setString(1, category);
				}

				if (!date.equals("none")) {
					statement.setString(2, date);
				}
	
				try (final ResultSet result = statement.executeQuery()) {
					final List<Event> events = new LinkedList<>();
					
					while (result.next()) {
						events.add(rowToEntity(result));
					}
					return events;
				}
				
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Error searching by category events", e);
			throw new DAOException(e);
		}
	}
	
	/**
	 * Returns a event stored persisted in the system.
	 * 
	 * @param category category of the event.
	 * @return a list of events with the provided category.
	 * @throws DAOException if an error happens while retrieving the event.
	 * @throws IllegalArgumentException if the provided category does not corresponds
	 * with any persisted event.
	 */
	public List<Event>  getByCategory(String categorysearch)
	throws DAOException, IllegalArgumentException {
		try (final Connection conn = this.getConnection()) {
			final String query = "SELECT * FROM event WHERE category LIKE ? ";
			
			try (final PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setString(1, categorysearch);
				
				try (final ResultSet result = statement.executeQuery()) {
					final List<Event> events = new LinkedList<>();
					
					while (result.next()) {
						events.add(rowToEntity(result));
					}
					return events;
				}
				
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Error searching by category events", e);
			throw new DAOException(e);
		}
	}
	
	/**
	 * Persists a new event in the system. An identifier will be assigned
	 * automatically to the new event.
	 * 
	 * @param name name of the new event. Can't be {@code null}.
	 * @param description description of the new event. Can't be {@code null}.
	 * @param date date of the new event. Can't be {@code null}.
	 * @param time name of the new event. Can't be {@code null}.
	 * @param category category of the new event. Can't be {@code null}.
	 * @param maxPlace maxPlace of the new event. Can't be {@code null}.
	 * @param location location of the new event. Can't be {@code null}.
	 * @return a {@link Event} entity representing the persisted event.
	 * @throws DAOException if an error happens while persisting the new event.
	 * @throws IllegalArgumentException if the name, date, time, category, 
	 * maxPlace or location are {@code null}.
	 */
//	public Event add(String name, String description, String date, String time, String category, int maxPlace, String location)
//	throws DAOException, IllegalArgumentException {
//		if (name == null || description == null || date == null || time == null || category == null) {
//			throw new IllegalArgumentException("name, type or idOwner can't be null");
//		}
//		
//		try (Connection conn = this.getConnection()) {
//			final String query = "INSERT INTO pets VALUES(null, ?, ?, ?)";
//			
//			try (PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//				statement.setString(1, name);
//				statement.setString(2, type);
//				statement.setInt(3, idOwner);
//				
//				if (statement.executeUpdate() == 1) {
//					try (ResultSet resultKeys = statement.getGeneratedKeys()) {
//						if (resultKeys.next()) {
//							return new Pet(resultKeys.getInt(1), name, type, idOwner);
//						} else {
//							LOG.log(Level.SEVERE, "Error retrieving inserted id");
//							throw new SQLException("Error retrieving inserted id");
//						}
//					}
//				} else {
//					LOG.log(Level.SEVERE, "Error inserting value");
//					throw new SQLException("Error inserting value");
//				}
//			}
//		} catch (SQLException e) {
//			LOG.log(Level.SEVERE, "Error adding a pet", e);
//			throw new DAOException(e);
//		}
//	}
	
	private Event rowToEntity(ResultSet row) throws SQLException {
		return new Event(
			row.getInt("id"),
			row.getString("name"),
			row.getString("description"),
			row.getDate("date"),
			row.getTime("time"),
			row.getString("category"),
			row.getInt("maxInscriptions"),
			row.getString("location")
		);
	}
}

