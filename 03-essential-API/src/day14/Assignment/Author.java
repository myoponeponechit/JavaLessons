package day14.Assignment;

public class Author {
	private String name;
	private String country;
	
	// constructors
	public Author() {
		
	}
	public Author(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	
	// getter/ setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
