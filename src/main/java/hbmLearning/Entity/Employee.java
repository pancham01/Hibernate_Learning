package hbmLearning.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

	
@NamedQuery(
		name = "Employee.findEmployeeById", 
		query = "FROM ducat_emp E WHERE E.id > :id"
		)
@NamedQuery(
	    name = "Employee.findByGender",
	    query = "SELECT e FROM ducat_emp e WHERE e.gender = :gender"
	)



@Entity(name = "ducat_emp")
public class Employee {
	
	@Column(name = "user_name")
	private String name;
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", id=" + id + "]";
	}

}
