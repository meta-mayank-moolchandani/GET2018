import java.util.ArrayList;
import java.util.List;

import animal.animals;
import zone.Zone;

public class Zoo {
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
		this.spareCapacity = capacity - listOfZone.size();
	}

	public List<Zone> listOfZone;

	Zoo(int zoneCapacity) {
		this.capacity = zoneCapacity;
		this.spareCapacity = zoneCapacity;
		listOfZone = new ArrayList<Zone>();
	}

	public boolean addZone(Zone zone) {
		if ((checkZoneAvailablity(zone)) && (spareCapacity > 0)
				&& (isZoneExist(zone.getZoneId()))) {
			listOfZone.add(zone);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	boolean checkZoneAvailablity(Zone zone) {
		boolean flag = false;
		for (animals value : animals.values()) {
			if (value.getCategory() == zone.getZoneCategory()) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean removeAnimal(int id) {
		boolean flag = true;

		if (!isZoneExist(id)) {
			int index = 0;
			for (Zone zone : listOfZone) {
				if (id == zone.getZoneId()) {
					break;
				}
				index++;
			}
			listOfZone.remove(index);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	private boolean isZoneExist(int id) {
		boolean flag = true;

		for (Zone zone : listOfZone) {
			if (zone.getZoneId() == id) {
				flag = false;
			}
		}

		return flag;
	}
}
