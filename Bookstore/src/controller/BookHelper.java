package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;

public class BookHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("bookstore");
	
	
	public void addBook(Book toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Book searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Book found = em.find(Book.class, idToEdit);
		em.close();
		return found;
	}

	public void updateBook(Book toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteBook(Book toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select ch from Book ch where ch.name = :selectedName and ch.author = :selectedAuthor and ch.publisher = :selectedPublisher and ch.purchaseDate = :selectedDate", Book.class);		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		typedQuery.setParameter("selectedPublisher", toDelete.getPublisher());
		typedQuery.setParameter("selectedDate", toDelete.getPurchaseDate());
		
		typedQuery.setMaxResults(1);
		
		Book result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Book> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<Book> allItems = em.createQuery("SELECT i FROM Book i").getResultList();
		return allItems;
	}

	public void cleanUp() {
		emfactory.close();
	}

}
