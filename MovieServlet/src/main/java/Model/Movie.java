package Model;

public class Movie {
	private int Id;
	private String name;
	private String theater;
	private int qty;
	private double price;
	
	
	public Movie() {
		
	}
	
	public Movie(int id, String name, String theater, int qty, double price) {
		
		this.Id = id;
		this.name = name;
		this.theater = theater;
		this.qty = qty;
		this.price = price;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
