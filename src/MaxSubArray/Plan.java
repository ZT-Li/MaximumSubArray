package MaxSubArray;

public class Plan {
	private int sum;
	private int arrival;
	private int departure;

	public Plan(int sum, int arrival, int departure) {
		this.sum = sum;
		this.arrival = arrival;
		this.departure = departure;
	}

	public void set(int sum, int arrival, int departure) {
		this.sum = sum;
		this.arrival = arrival;
		this.departure = departure;
	}

	public int getSum() {
		return sum;
	}
	
	public boolean equals(Plan p) {
		if(this.sum==p.sum && this.arrival==p.arrival && this.departure==p.departure)
			return true;
		else
			return false;
	}

	public String toString() {
		return "MaxSum: " + sum + " Arrival: " + arrival + " Departure: " + departure;
	}
}
