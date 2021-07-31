package com.geekcolab.development.f;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToOne
	@JoinColumn(name="office_id")
	private Office office;

	public Employee() {
	}

	public Employee(String name, String address, Office office) {
		super();
		this.name = name;
		this.address = address;
		this.office = office;
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
				", office=" + office +
				'}';
	}
}
