import java.util.ArrayList;

public class Warehouse {
	
	private ArrayList<InventoryItem> items;
	
	//returns an ArrayList of all items whose price is between
	//loPrice and hiPrice inclusive
	public ArrayList<InventoryItem> getItems(double loPrice, double hiPrice)
	{
		ArrayList<InventoryItem> answers = new ArrayList<InventoryItem>();
		for(int i = 0; i < items.size(); i++) {
			if (items.get(i).getPrice() >= loPrice &&
					items.get(i).getPrice() <= hiPrice) {
				answers.add(items.get(i));
			}
		}
		/* for(InventoryItem ii : items)
		 * {
		 *   if (ii.getPrice() >= loPrice &&
					ii.getPrice() <= hiPrice) {
				answers.add(ii);
			}  
		 */
		return answers;
	}
	
	
}