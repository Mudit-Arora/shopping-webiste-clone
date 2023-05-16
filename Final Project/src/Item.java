import java.util.ArrayList;

public class Item {
	
	private int serialNumber;
	private String name;
	private double price;
	private int quantity;
	private String description;
	
	public static final ArrayList<Item> arrlist  = new ArrayList<Item>();
		
	
	public int getQuantity() {
		return quantity;
	}
	public void setgetQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	Item(int x,String a, double b, String c, int d) {
		this.serialNumber = x;
		this.name = a;
		this.price = b;
		this.description = c;
		this.quantity = d;
	}
	
	Item(int x,String a, double b, int c) {
		this.serialNumber = x;
		this.name = a;
		this.price = b;
		this.quantity = c;
	}
	
	Item(String a, double b, String c) {
		this.name = a;
		this.price = b;
		this.description = c;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static void addNewItem(int a, String b, double c, int d) {
	arrlist.add(new Item(a, b, c, d));
	}
	
	public static void searchMethod(String name) {
		
		
		
	}
	public static Object populateStore() {
		arrlist.add(new Item( 1, "Mask", 3, 1));
		arrlist.add(new Item( 2, "Bag", 20, 1));
		arrlist.add(new Item(3, "Jacket", 50, 1));
		arrlist.add(new Item(4, "Hoodie", 40, 1));	
		arrlist.add(new Item(5, "Phone", 899, 1));
		arrlist.add(new Item(6, "Laptop", 1599, 1));
		arrlist.add(new Item(7, "Shoes", 80, 1));
		arrlist.add(new Item(8, "Jeans", 80, 1));
		arrlist.add(new Item(9, "Perfume", 120, 1));
		arrlist.add(new Item(10, "Notebook", 1, 1));
		arrlist.add(new Item(11, "Pens", 0.69, 1));
		arrlist.add(new Item(12, "Calculator", 150, 1));
		arrlist.add(new Item(13, "Watch", 199, 1));
		arrlist.add(new Item( 14, "Bedset", 35, 1));
		arrlist.add(new Item( 15, "Juice", 10, 1));
		arrlist.add(new Item( 16, "Soda", 3, 1));
		return null;			
	}
	
	public static String getQuantityAt(int x) {
		String result = String.valueOf(arrlist.get(x).getQuantity());		
		return result;
	}
	public static String getNameAt(int x) {
		 String result = arrlist.get(x).getName();	
		return result;
	}
	public static String getPriceAt(int x) {
		String result = String.valueOf(arrlist.get(x).getPrice());
		return result;
	}
	public static String getSerialNumberAt(int x) {
		String result = String.valueOf(arrlist.get(x).getSerialNumber());
		return result;
	}
	public static int getLength() {
		return arrlist.size();
	}
	
	public static void removeAt(int x) {
		arrlist.remove(x);
	}
	
}
