package hbmLearning.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findEmployeeByName",  
	        query = "from Holi  where name = :name"  
	        )  
	    }  
	)  

@Entity(name = "Holi")
//@Table(name = "Holi")
public class Employee {
	@Column(name = "user_name")
	private String name;
	@Column(name = "seriousIssue")
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
