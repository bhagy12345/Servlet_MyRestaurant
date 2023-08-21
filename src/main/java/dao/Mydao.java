package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dto.customer;

public class Mydao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	public void save(customer c) {
	transaction.begin();
	manager.persist(c);
	transaction.commit();
	}
	public customer fetchByEmail(String email)
	{
		List<customer> list= manager.createQuery("select x from customer x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	public customer fetchByMobile(long number)
	{
		List<customer> list= manager.createQuery("select x from customer x where number=?1").setParameter(1, number).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
}
