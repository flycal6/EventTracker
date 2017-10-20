package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fillup create(String quizJSON) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fillup update(int id, String quizJSON) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
