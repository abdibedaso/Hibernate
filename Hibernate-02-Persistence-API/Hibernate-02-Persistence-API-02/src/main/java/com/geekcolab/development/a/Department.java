package com.geekcolab.development.a;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@OneToMany(mappedBy="department")
	private List<Employee> employees = new ArrayList();

	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	private void setId(long id) {
		this.id = id;
	}

	public void addEmployees(Employee employee) {
		this.employees.add(employee);
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", employees=" + employees +
				'}';
	}
}
