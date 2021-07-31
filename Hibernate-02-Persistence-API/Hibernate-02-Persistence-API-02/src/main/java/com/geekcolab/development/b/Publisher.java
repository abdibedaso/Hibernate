package com.geekcolab.development.b;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	public Publisher() {
	}

	public Publisher(String name) {
		this.name = name;
	}

	private void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Publisher{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
