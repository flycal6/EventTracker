package data;

import java.util.List;

import entities.Fillup;

public interface FillupDAO {
	public List<Fillup> index();
	public Fillup show(int id);
	public Fillup create(String quizJSON);
	public Fillup update(int id, String quizJSON);
	public boolean destroy(int id);
}
