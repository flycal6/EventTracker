package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.FillupDAO;
import entities.Fillup;

@RestController
@RequestMapping(value="/fillups")
public class FillupController {

	@Autowired
	private FillupDAO fillupDao;

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public List<Fillup> index(HttpServletResponse res){
		res.setStatus(202);
		return fillupDao.index();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Fillup show(@PathVariable int id, HttpServletResponse res) {
		res.setStatus(202);
		return fillupDao.show(id);
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public Fillup create(@RequestBody String fillupJSON, HttpServletResponse res) {
		res.setStatus(201);
		return fillupDao.create(fillupJSON);
	}
	
	@RequestMapping(path="/{1d}", method = RequestMethod.PUT)
	public Fillup update(@PathVariable int id, @RequestBody String fillupJSON, HttpServletResponse res) {
		res.setStatus(204);
		return fillupDao.update(id, fillupJSON);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id, HttpServletResponse res) {
		res.setStatus(204);
		return fillupDao.destroy(id);
	}
}
