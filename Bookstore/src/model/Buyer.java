 package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	//only getters and setters below here
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Name: " + fname + " " + lname + " Location: " + city + ", " + state;
	}
	
	
	//constructor without id
	public Buyer(String fname, String lname, String city, String state) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
	}

	//all fields constructor
	public Buyer(int id, String fname, String lname, String city, String state) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
	}

	//super constructor
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

}

