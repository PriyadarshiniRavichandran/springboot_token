package com.tnsif.placementservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Placement {
	@Id
	@Column(name="Sid")
	private int id;
	@Column(name="Smobileno")
	private int mobileno;
	@Column(name="Sname")
	private String name;
	@Column(name="Saddress")
	private String address;
	@Column(name="Sdept")
	private String dept;
	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Placement(int id, int mobileno, String name, String address, String dept) {
		super();
		this.id = id;
		this.mobileno = mobileno;
		this.name = name;
		this.address = address;
		this.dept = dept;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Placement [id=" + id + ", mobileno=" + mobileno + ", name=" + name + ", address=" + address + ", dept="
				+ dept + "]";
	}
	
}
