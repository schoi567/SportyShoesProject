package com.test.example.entity;

import java.util.Date;
import java.util.Objects;


public class Directors {

	private Long id;	
	private String Name;
	private DirectorPositionType position;
	private Date termrenewal; 
	
	
	public Directors() {
		
	}

	 

	public Directors(long id, String name, DirectorPositionType position, Date termrenewal) {
		super();
		this.id = id;
		this.Name = name;
		this.position = position;
		this.termrenewal = termrenewal;
	
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	 
	

	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public DirectorPositionType getPosition() {
		return position;
	}



	public void setPosition(DirectorPositionType position) {
		this.position = position;
	}



	public Date getTermrenewal() {
		return termrenewal;
	}



	public void setTermrenewal(Date termrenewal) {
		this.termrenewal = termrenewal;
	}







	@Override
	public int hashCode() {
		return Objects.hash(position, id, termrenewal, Name);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directors other = (Directors) obj;
		return Objects.equals(position, other.position) && id == other.id 
				&& Objects.equals(termrenewal, other.termrenewal) && Objects.equals(Name, other.Name);
	}

	
	
	
}
