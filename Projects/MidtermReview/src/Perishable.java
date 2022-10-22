
public class Perishable extends InventoryItem {

	private Date expirationDate;
	
	public Perishable(Date entry, double price, Date expDat) {
		super(entry, price);
		expirationDate = expDat;
	}
	
	public double getPrice() {
		//Assume Date has a proper compareTo method definition
		if (getEntryDate().compareTo(expirationDate) > 0) {  //if the entry date is greater than the expiration date (YUCK)
			
			return getBasePrice() - (getBasePrice() * .9);
		} else {
			return super.getBasePrice();
		}
		
	}
	
}
