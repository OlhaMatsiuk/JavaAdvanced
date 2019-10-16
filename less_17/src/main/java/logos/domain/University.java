package logos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int levelOfAccreditation;
	
	@Column
	private int numberOfInstitutes;
	
	@Column
	private int amounOfStudents;
	
	@Column
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevelOfAccreditation() {
		return levelOfAccreditation;
	}
	public void setLevelOfAccreditation(int levelOfAccreditation) {
		this.levelOfAccreditation = levelOfAccreditation;
	}
	public int getNumberOfInstitutes() {
		return numberOfInstitutes;
	}
	public void setNumberOfInstitutes(int numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}
	public int getAmounOfStudents() {
		return amounOfStudents;
	}
	public void setAmounOfStudents(int amounOfStudents) {
		this.amounOfStudents = amounOfStudents;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", levelOfAccreditation=" + levelOfAccreditation
				+ ", numberOfInstitutes=" + numberOfInstitutes + ", amounOfStudents=" + amounOfStudents + ", address="
				+ address + "]";
	}


}
