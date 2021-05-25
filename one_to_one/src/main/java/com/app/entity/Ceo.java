package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ceo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	@OneToOne(mappedBy="ceo",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Company com;
	
	public Company getCom() {
		return com;
	}
	public void setCom(Company com) {
		this.com = com;
	}
	@Override
	public String toString() {
		return "Ceo [id=" + id + ", name=" + name + "]";
	}

	
}
