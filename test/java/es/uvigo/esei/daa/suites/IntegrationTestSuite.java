package es.uvigo.esei.daa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import es.uvigo.esei.daa.rest.UsersResourceTest;

@SuiteClasses({ 
	UsersResourceTest.class
})
@RunWith(Suite.class)
public class IntegrationTestSuite {
}
