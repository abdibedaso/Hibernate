package com.geekcolab.development;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String year;
	private double price;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ownerId")
	private Owner owner;

	public Car() {
	}

	public Car(String brand, String year, double price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	private void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car{" +
				"id=" + id +
				", brand='" + brand + '\'' +
				", year='" + year + '\'' +
				", price=" + price +
				", owner=" + owner +
				'}';
	}

}
