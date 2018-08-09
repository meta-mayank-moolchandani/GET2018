package employee;

public class Address {
	private int houseNo;
	private String locality;
	private String city;
	
	public Address(int houseNo,String locality,String city)
	{
		this.houseNo = houseNo;
		this.locality = locality;
		this.city = city;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public String getLocality() {
		return locality;
	}

	public String getCity() {
		return city;
	}	
}
