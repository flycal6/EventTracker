package data;

import java.util.List;

import entities.Fillup;

public interface FillupDAO {
	public List<Fillup> index();
	public Fillup show(int id);
	public Fillup create(String fillupJSON);
	public Fillup update(int id, String fillupJSON);
	public boolean destroy(int id);
}
