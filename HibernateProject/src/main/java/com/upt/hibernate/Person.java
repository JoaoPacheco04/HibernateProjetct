package com.upt.hibernate;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "contact_number")
	private int numberPhone;

	public Person(Long id, String name, int numberPhone) {
		this.id = id;
		this.name = name;
		this.numberPhone = numberPhone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(int numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	
	
}
