package cage;

import animal.*;

import java.util.*;

public class Cage {
	public Cage(String cageType, int capacity) {
		super();

		this.cageType = cageType.toUpperCase();
		this.capacity = capacity;
		spareCapacity = capacity;
		listOfAnimal = new ArrayList<Animal>();
		setCageCategory();
		setCageId();
	}
	

	void setSpareCapacity() {
		spareCapacity = capacity - listOfAnimal.size();
	}
	
	private int cageId;
	private String cageType;
	private String cageCategory;

	/**
	 * @return the cageCategory
	 */
	public String getCageCategory() {
		return cageCategory;
	}

	/**
	 * @param cageCategory
	 *            the cageCategory to set
	 */
	public void setCageCategory() {
		for (animals animalEnum : animals.values()) {
			if (cageType.equalsIgnoreCase(animalEnum.getType())) {
				cageCategory = animalEnum.getCategory();
			}
		}
	}

	private int capacity;

	/**
	 * @return the cageType
	 */
	public String getCageType() {
		return cageType;
	}

	private int spareCapacity;
	public List<Animal> listOfAnimal;

	boolean isAnimalExist(int id) {
		boolean flag = true;
		for (Animal x : listOfAnimal) {
			if (x.getId() == id) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public boolean addAnimal(Animal animal) {
		if (animal.type.equalsIgnoreCase(cageType) && spareCapacity > 0
				&& isAnimalExist(animal.getId())) {
			listOfAnimal.add(animal);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	public boolean removeAnimal(int id) {
		boolean flag = true;

		if (!isAnimalExist(id)) {
			int index = 0;
			for (Animal animal : listOfAnimal) {
				if (id == animal.getId()) {
					break;
				}
				index++;
			}
			listOfAnimal.remove(index);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public void setCageId() {
		double random = Math.random();
		this.cageId = (int) (random * 1000);
	}

	public int getCageId() {
		return this.cageId;
	}

}
