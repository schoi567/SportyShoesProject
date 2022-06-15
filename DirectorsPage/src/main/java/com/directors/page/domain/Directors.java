package com.directors.page.domain;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
 
@Entity
@Table(name="Directors")
public class Directors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String position;
	private Date termrenewal;

	
	public Directors() {}

	public Directors
	(Long id, @NotEmpty String username, @NotEmpty String position, Date termrenewal) 
	{super();
		this.id = id;
		this.name = username;
		this.position = position;
		this.termrenewal = termrenewal;}



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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
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
		return Objects.hash(position, id, termrenewal, name);
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
				&& Objects.equals(termrenewal, other.termrenewal) && Objects.equals(name, other.name);
	}

	
}


