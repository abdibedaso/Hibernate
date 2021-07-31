package com.geekcolab.development.a;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeNumber;

	private String name;
	private String address;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	public Employee() {
	}

	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	private void setId(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeNumber=" + employeeNumber +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
