package hbmLearning.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Many-to-Many relationship with Address
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_address", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private Set<Address> addresses = new HashSet<>();

	// Constructors
	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
		address.getEmployees().add(this); // ensure bi-directional mapping
	}
}
