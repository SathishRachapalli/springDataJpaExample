package com.dataJpaExample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//The annotations(such as @entity,@Table e.t.c.,) are all needs to pick from 'jakarta.persistence' API
//After adding the 'jakarta.persistence-api' dependency click (ctrl+shift+o) these annotations will be available.


@Entity
@Table(name="friends")
public class employee {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empId")
	int id;
	@Column(name="empName")
	String Name;
	public employee(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", Name=" + Name + "]";
	}
	
	

}
