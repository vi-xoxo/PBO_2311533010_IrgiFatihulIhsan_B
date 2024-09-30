package DAO;

import java.util.List;

import model.Costumer;

public interface CostumerDAO {
	void save(Costumer costumer);
	public List<Costumer> show();
	public void delete (String id);
	public void update (Costumer costumer);
}
