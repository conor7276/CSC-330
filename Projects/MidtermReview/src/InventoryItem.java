
public abstract class InventoryItem {

	private int id;
	private Date entry;
	private double basePrice;
	
	public InventoryItem(Date entryDate, double price) {
		id = makeId();
		entry = entryDate;
		basePrice = price;
	}
	
	public Date getEntryDate() {
		return entry;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	abstract public double getPrice();
	
	private static int makeId() {
		return (int)(Math.random() * 10000);
	}
	
}