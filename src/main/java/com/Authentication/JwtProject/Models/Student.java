package com.Authentication.JwtProject.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long s_id;
	private String s_name;
	
	@Column(unique=true)
	private String s_email;
	
	@ManyToOne
	@JoinColumn(name="c_id")
	private College college;
	
	public Student()  {}
	
	public Student(Long si, String sn, String se,College c)
	{
		this.s_id=si;
		this.s_name=sn;
		this.s_email=se;
		this.college=c;
	}

	public Long getS_id() {
		return s_id;
	}

	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	
	

	
}
