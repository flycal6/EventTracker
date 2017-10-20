package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Fillup;

public class FillupTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Fillup fillup = null;
	
	
	

	@Before
	public void setup() throws Exception {
		emf = Persistence.createEntityManagerFactory("GasTracker");
		em = emf.createEntityManager();
		fillup = em.find(Fillup.class, 1);
	}

	@After
	public void teardown() {
		fillup = null;
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		boolean bool = true;
		assertEquals(true, bool);
	}
}
