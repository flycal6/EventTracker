package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fillup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double price;
	private double gallons;
	private int odometer;

	/**************** Gets and Sets ************************/

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getGallons() {
		return gallons;
	}

	public void setGallons(double gallons) {
		this.gallons = gallons;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fillup [id=");
		builder.append(id);
		builder.append(", price=");
		builder.append(price);
		builder.append(", gallons=");
		builder.append(gallons);
		builder.append(", odometer=");
		builder.append(odometer);
		builder.append("]");
		return builder.toString();
	}

}
