package zone;

import java.util.*;
import cage.Cage;

public class Zone {
	private int zoneId;

	/**
	 * @return the zoneCategory
	 */
	public String getZoneCategory() {
		return zoneCategory;
	}

	private String zoneCategory;
	private int capacity;
	private int spareCapacity;

	/**
	 * @return the spareCapacity
	 */
	public int getSpareCapacity() {
		return spareCapacity;
	}

	/**
	 * @param spareCapacity
	 *            the spareCapacity to set
	 */
	public void setSpareCapacity() {
		this.spareCapacity = capacity - listOfCage.size();
	}

	public List<Cage> listOfCage;

	public Zone(String zoneCategory, int capacity) {
		this.zoneCategory = zoneCategory.toUpperCase();
		this.capacity = capacity;
		this.spareCapacity = capacity;
		listOfCage = new ArrayList<Cage>();
		setZoneId();
	}

	public boolean addCage(Cage cage) {
		if ((zoneCategory.equalsIgnoreCase(cage.getCageCategory()))
				&& (spareCapacity > 0) && (isCageExist(cage.getCageId()))) {

			listOfCage.add(cage);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	public boolean removeAnimal(int id) {
		boolean flag = true;

		if (!isCageExist(id)) {
			int index = 0;
			for (Cage cage : listOfCage) {
				if (id == cage.getCageId()) {
					break;
				}
				index++;
			}
			listOfCage.remove(index);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public void setZoneId() {
		double random = Math.random();
		this.zoneId = (int) (random * 1000);
	}

	public int getZoneId() {
		return this.zoneId;
	}

	private boolean isCageExist(int id) {
		boolean flag = true;

		for (Cage x : listOfCage) {
			if (x.getCageId() == id) {
				flag = false;
			}
		}

		return flag;
	}

}
