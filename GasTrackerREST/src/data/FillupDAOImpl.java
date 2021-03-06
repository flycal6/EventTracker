package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Fillup;

@Transactional
@Repository
public class FillupDAOImpl implements FillupDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Fillup> index() {
		String query = "SELECT f FROM Fillup f";
		return em.createQuery(query, Fillup.class).getResultList();
	}

	@Override
	public Fillup show(int id) {
		return em.find(Fillup.class, id);
	}

	@Override
	public Fillup create(String fillupJSON) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Fillup mappedFillup = mapper.readValue(fillupJSON, Fillup.class);
			em.persist(mappedFillup);
			em.flush();
			return mappedFillup;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Fillup update(int id, String fillupJSON) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Fillup fillupUpdate = em.find(Fillup.class, id);
			Fillup mappedFillup = mapper.readValue(fillupJSON, Fillup.class);
			
			fillupUpdate.setGallons(mappedFillup.getGallons());
			fillupUpdate.setPrice(mappedFillup.getPrice());
			fillupUpdate.setOdometer(mappedFillup.getOdometer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean destroy(int id) {
		try {
			em.remove(em.find(Fillup.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
