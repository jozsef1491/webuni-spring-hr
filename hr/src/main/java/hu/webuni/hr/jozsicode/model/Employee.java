package hu.webuni.hr.jozsicode.model;

import java.time.LocalDate;

public class Employee {

	long id;
	String name;
//	String post;
	Post post;
	int payment;
	LocalDate startingDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getPost() {
//		return post;
//	}

//	public void setPost(String post) {
//		this.post = post;
//	}
	
	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post=post;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public Employee(long id, String name, Post post, int payment, LocalDate startingDate) {
		this.id = id;
		this.name = name;
//		this.post = post;
		this.post=post;
		this.payment = payment;
		this.startingDate = startingDate;
	}

	public Employee() {

	}



}
