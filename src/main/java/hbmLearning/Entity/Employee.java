package hbmLearning.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "employee2")
public final class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_gender")
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	List<Address> address;

	public Employee(String name, String gender, int id, List<Address> address) {
		super();
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.address = address;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

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
