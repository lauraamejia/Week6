package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="purchaseDate")
	private LocalDate purchaseDate;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="buyer_id")
	private Buyer buyer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyerID) {
		this.buyer = buyerID;
	}
	@Override
	public String toString() {
		return name + " is a " + author + " (publisher= " + publisher + "). Purchased on " + purchaseDate + " by " + buyer.getFname();
	}
	
	public void setNullBuyer() {
		this.buyer = null;
	}
	
	//constructor without id or owner
		public Book(String name, String author, String publisher, LocalDate purchaseDate) {
			super();
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.purchaseDate = purchaseDate;
		}
	
	//constructor without id
	public Book(String name, String author, String publisher, LocalDate purchaseDate, Buyer buyer) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.purchaseDate = purchaseDate;
		this.buyer = buyer;
	}


	//all fields constructor
	public Book(int id, String name, String author, String publisher, LocalDate purchaseDate, Buyer buyerID) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.purchaseDate = purchaseDate;
		this.buyer = buyerID;
	}
	//super constructor
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

}
