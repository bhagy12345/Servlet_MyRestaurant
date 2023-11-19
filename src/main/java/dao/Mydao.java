package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Cart;
import dto.customer;
import dto.CustomerFoodItem;
import dto.Fooditem;

public class Mydao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(customer customer) {
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}
	
	public void save(Fooditem item) {
		transaction.begin();
		manager.persist(item);
		transaction.commit();
	}

	public customer fetchByEmail(String email) {

		List<customer> list = manager.createQuery("select x from customer x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	public customer fetchByMobile(long mobile) {
		List<customer> list = manager.createQuery("select x from customer x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
	public List<Fooditem> fetchAllFoodItem()
	{
		return manager.createQuery("select x from Fooditem x").getResultList();
	}
	
	public Fooditem find(int id)
	{
		return manager.find(Fooditem.class, id);
	}
	
	public void delete(Fooditem item)
	{
		transaction.begin();
		manager.remove(item);
		transaction.commit();
	}

	public void update(Fooditem item) {
		transaction.begin();
		manager.merge(item);
		transaction.commit();
	}
	
	public void update(customer customer) {
		transaction.begin();
		manager.merge(customer);
		transaction.commit();
	}
	
	public void update(Cart cart) {
		transaction.begin();
		manager.merge(cart);
		transaction.commit();
	}
	
	public void update(CustomerFoodItem foodItem) {
		transaction.begin();
		manager.merge(foodItem);
		transaction.commit();
	}
     
	public List<customer> fetchAllCustomer() {
		return manager.createQuery("select x from customer x").getResultList();
	}

	public customer findCustomer(int id) {
		return manager.find(customer.class, id);
	}

	public void delete(customer customer) {
		transaction.begin();
		manager.remove(customer);
		transaction.commit();
	}
}	