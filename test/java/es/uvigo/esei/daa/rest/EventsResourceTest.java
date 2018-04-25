package es.uvigo.esei.daa.rest;

import static es.uvigo.esei.daa.dataset.EventsDataset.advancedSearchedEvents;
import static es.uvigo.esei.daa.dataset.EventsDataset.events;
import static es.uvigo.esei.daa.dataset.EventsDataset.existenCategory;
import static es.uvigo.esei.daa.dataset.EventsDataset.existentEvent;
import static es.uvigo.esei.daa.dataset.EventsDataset.existentId;
import static es.uvigo.esei.daa.dataset.EventsDataset.newDate;
import static es.uvigo.esei.daa.dataset.EventsDataset.newSearch;
import static es.uvigo.esei.daa.dataset.EventsDataset.nonExistentId;
import static es.uvigo.esei.daa.dataset.EventsDataset.searchedEvents;
import static es.uvigo.esei.daa.matchers.HasHttpStatus.hasBadRequestStatus;
import static es.uvigo.esei.daa.matchers.HasHttpStatus.hasOkStatus;
import static es.uvigo.esei.daa.matchers.IsEqualToEvent.containsEventsInAnyOrder;
import static es.uvigo.esei.daa.matchers.IsEqualToEvent.equalsToEvent;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import es.uvigo.esei.daa.LETTAApplication;
import es.uvigo.esei.daa.entities.Event;
//import es.uvigo.esei.daa.entities.Person;
import es.uvigo.esei.daa.listeners.ApplicationContextBinding;
import es.uvigo.esei.daa.listeners.ApplicationContextJndiBindingTestExecutionListener;
import es.uvigo.esei.daa.listeners.DbManagement;
import es.uvigo.esei.daa.listeners.DbManagementTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:contexts/mem-context.xml")
@TestExecutionListeners({
	DbUnitTestExecutionListener.class,
	DbManagementTestExecutionListener.class,
	ApplicationContextJndiBindingTestExecutionListener.class
})
@ApplicationContextBinding(
	jndiUrl = "java:/comp/env/jdbc/letta",
	type = DataSource.class
)
@DbManagement(
	create = "classpath:db/hsqldb.sql",
	drop = "classpath:db/hsqldb-drop.sql"
)
@DatabaseSetup("/datasets/dataset.xml")
@ExpectedDatabase("/datasets/dataset.xml")
public class EventsResourceTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new LETTAApplication();
	}

	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		
		// Enables JSON transformation in client
		config.register(JacksonJsonProvider.class);
		config.property("com.sun.jersey.api.json.POJOMappingFeature", Boolean.TRUE);
	}
	
	@Test
	public void testList() throws IOException {
		final Response response = target("events").request().get();
		assertThat(response, hasOkStatus());

		final List<Event> events = response.readEntity(new GenericType<List<Event>>(){});
		
		assertThat(events, containsEventsInAnyOrder(events()));
	}

	@Test
	public void testGet() throws IOException {
		final Response response = target("events/" + existentId()).request().get();
		assertThat(response, hasOkStatus());
		
		final Event event = response.readEntity(Event.class);
		
		assertThat(event, is(equalsToEvent(existentEvent())));
	}

	@Test
	public void testGetInvalidId() throws IOException {
		final Response response = target("events/" + nonExistentId()).request().get();
		
		assertThat(response, hasBadRequestStatus());
	}
	
	@Test
	public void testgetByWord() throws IOException {
		final Response response = target("events")
			.queryParam("search", newSearch())
			.request()
		.get();
		assertThat(response, hasOkStatus());
		
		final List<Event> events = response.readEntity(new GenericType<List<Event>>(){});
		System.out.println(events);
		assertThat(events, containsEventsInAnyOrder(searchedEvents()));
	}	
	
	@Test
	public void testgetByCategory() throws IOException {
		final Response response = target("events")
			.queryParam("category", existenCategory())
			.request()
		.get();
		assertThat(response, hasOkStatus());
		
		final List<Event> events = response.readEntity(new GenericType<List<Event>>(){});
		System.out.println(events);
		assertThat(events, containsEventsInAnyOrder(searchedEvents()));
	}
	
	@Test
	public void testAdvancedSearch() throws IOException {
		final Response response = target("events")
			.queryParam("category", existenCategory())
			.queryParam("date", newDate())
			.queryParam("order", "none")
			.request()
		.get();
		assertThat(response, hasOkStatus());
		
		final List<Event> events = response.readEntity(new GenericType<List<Event>>(){});
		System.out.println(events);
		assertThat(events, containsEventsInAnyOrder(advancedSearchedEvents()));
	}
}
