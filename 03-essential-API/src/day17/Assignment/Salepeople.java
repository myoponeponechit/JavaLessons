package day17.Assignment;

public class Salepeople {
	
	private String name;
	private String city;
	private double comm;
	
	public Salepeople() {
		
	}

	public Salepeople(String name, String city, double comm) {
		super();
		this.name = name;
		this.city = city;
		this.comm = comm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "name = " + name + "\n city = " + city + "\n comm = " + comm;
	}
	
}
