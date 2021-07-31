package com.geekcolab.development;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;

	public Owner() {
	}

	public Owner(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	private void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Owner{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
