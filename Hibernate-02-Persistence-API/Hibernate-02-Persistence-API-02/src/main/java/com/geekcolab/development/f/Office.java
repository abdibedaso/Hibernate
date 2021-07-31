package com.geekcolab.development.f;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long roomNumber;
	private String building;

	@OneToMany(mappedBy="office")
	private List<Employee> employees = new ArrayList();

	public Office() {
	}

	public Office(long roomNumber, String building) {
		this.roomNumber = roomNumber;
		this.building = building;
	}

	private void setId(long id) {
		this.id = id;
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	@Override
	public String toString() {
		return "Office{" +
				"roomNumber=" + roomNumber +
				", building='" + building + '\'' +
				'}';
	}
}
