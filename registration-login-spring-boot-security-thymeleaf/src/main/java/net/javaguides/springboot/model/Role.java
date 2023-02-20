package net.javaguides.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	// The id field will be generated automatically in the database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// The name of the role
	private String name;

	public Role() {
		// An empty constructor is needed for Hibernate to instantiate the object
	}

	public Role(String name) {
		this.name = name;
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
}
