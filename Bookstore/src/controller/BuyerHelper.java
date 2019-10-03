package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Buyer;

public class BuyerHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("bookstore");
	
	public void insertBuyer(Buyer o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Buyer> showAllBuyers(){
		EntityManager em = emfactory.createEntityManager();
		List<Buyer> allBuyers = em.createQuery("SELECT i FROM Buyer i").getResultList();
		return allBuyers;
	}
	
	public void deleteBuyer(Buyer toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select o from Buyer o where o.fname = :selectedFname and o.lname = :selectedLname and o.city = :selectedCity and o.state = :selectedState", Buyer.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFname", toDelete.getFname());
		typedQuery.setParameter("selectedLname", toDelete.getLname());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedState", toDelete.getState());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Buyer result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Buyer searchForBuyerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Buyer found = em.find(Buyer.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateBuyer(Buyer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Buyer> searchForBuyerByCity(String city) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select o from Buyer o where o.city = :selectedCity", Buyer.class);
		typedQuery.setParameter("selectedCity", city);
		
		List<Buyer> foundBuyers = typedQuery.getResultList();
		em.close();
		return foundBuyers;
	}
	
	public List<Buyer> searchForBuyerByState(String state) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select o from Buyer o where o.state = :selectedState", Buyer.class);
		typedQuery.setParameter("selectedState", state);
		
		List<Buyer> foundBuyers = typedQuery.getResultList();
		em.close();
		return foundBuyers;
	}
	
	public List<Buyer> searchForBuyerByFname(String fname) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select o from Buyer o where o.fname = :selectedFname", Buyer.class);
		typedQuery.setParameter("selectedFname", fname);
		
		List<Buyer> foundBuyers = typedQuery.getResultList();
		em.close();
		return foundBuyers;
	}
	
	public List<Buyer> searchForBuyerByLname(String lname) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select o from Buyer o where o.lname = :selectedLname", Buyer.class);
		typedQuery.setParameter("selectedLname", lname);
		
		List<Buyer> foundBuyers = typedQuery.getResultList();
		em.close();
		return foundBuyers;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
