package es.uvigo.esei.daa.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.uvigo.esei.daa.dao.DAOException;
import es.uvigo.esei.daa.dao.EventsDAO;
import es.uvigo.esei.daa.entities.Event;
/**
 * REST resource for managing events.
 * 
 * @author Brais Álvarez Fernández
 * @author Jose Eugenio González Fernández.
 */
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventsResource {
	private final static Logger LOG = Logger.getLogger(EventsResource.class.getName());
	
	private final EventsDAO dao;
	
	// The HttpServletRequest can be also injected as a parameter in the REST
	// methods.
	private @Context HttpServletRequest request;
	
	/**
	 * Constructs a new instance of {@link EventsResource}.
	 */
	public EventsResource() {
		this(new EventsDAO());
	}
	
	// Needed for testing purposes
	EventsResource(EventsDAO dao) {
		this(dao, null);
	}
	
	// Needed for testing purposes
	EventsResource(EventsDAO dao, HttpServletRequest request) {
		this.dao = dao;
		this.request = request;
	}
	
	/**
	 * Returns an event
	 * 
	 * @param id of the event to retrieve.
	 * 
	 */
	@GET
	@Path("/{id}")
	public Response get(
		@PathParam("id") int id
	) {
		try {
			final Event event = this.dao.get(id);
			
			return Response.ok(event).build();
		} catch (IllegalArgumentException iae) {
			LOG.log(Level.FINE, "Invalid event id in get method", iae);
			
			return Response.status(Response.Status.BAD_REQUEST)
				.entity(iae.getMessage())
			.build();
		} catch (DAOException e) {
			LOG.log(Level.SEVERE, "Error getting an event", e);
			
			return Response.serverError()
				.entity(e.getMessage())
			.build();
		}
	}
	

	
	/**
	 * Returns a list of events which matches with param 
	 * 
	 * @param search for the events to retrieve.
	 * 
	 */
	@GET
	public Response list(
		@QueryParam("search") String search,
		@QueryParam("category") String category,
		@QueryParam("date") String date,
		@QueryParam("order") String order
	) {
		try {
			final List<Event> events;
			if (search != null) {
				events = this.dao.getByWord(search);
			} else if (category != null) {
				if (date != null && order != null) {
					events = this.dao.advancedSearch(category,date,order);
				} else {
					events = this.dao.getByCategory(category);
				}
			} else {
				events = this.dao.list();
			}
			
			return Response.ok(events).build();
		} catch (IllegalArgumentException iae) {
			LOG.log(Level.FINE, "Invalid event search", iae);
			
			return Response.status(Response.Status.BAD_REQUEST)
				.entity(iae.getMessage())
			.build();
		} catch (DAOException e) {
			LOG.log(Level.SEVERE, "Error getting a list of events", e);
			
			return Response.serverError()
				.entity(e.getMessage())
			.build();
		}
	}
	
	
}
