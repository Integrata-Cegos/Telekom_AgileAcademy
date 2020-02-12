package org.javacream.jpa.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

	private String name;
	private double weight;
	private String furColor;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Cat(String name, double weight, String furColor) {
		super();
		this.name = name;
		this.weight = weight;
		this.furColor = furColor;
	}
	
	public void annoy() {
		System.out.println("miauuu");
	}
	
	//JPA
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long catId;
	
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	public Long getCatId() {
		return catId;
	}
	Cat() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (catId ^ (catId >>> 32));
		result = prime * result + ((furColor == null) ? 0 : furColor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (catId != other.catId)
			return false;
		if (furColor == null) {
			if (other.furColor != null)
				return false;
		} else if (!furColor.equals(other.furColor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", weight=" + weight + ", furColor=" + furColor + ", catId=" + catId + "]";
	}
}
