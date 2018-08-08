package chooseBowler;



public class Bowler {
	private String name;
	private int quota;


	public Bowler(String name, int quota) {
		this.name = name;
		this.quota = quota;
	}
	
	public String getName() {
		return name;
	}

	public int getQuota() {
		return quota;
	}


}
