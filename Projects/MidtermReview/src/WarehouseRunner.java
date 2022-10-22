import java.util.ArrayList;
public class WarehouseRunner {
    public static void main(String args[]){
        InventoryItem item1 = new Perishable(new Date(10,22,2022), 2, new Date(10,30,2022));
        InventoryItem item2 = new Perishable(new Date(10,22,2022), 3, new Date(10,20,2022));
        InventoryItem item3 = new Perishable(new Date(10,22,2022),2.50, new Date(10,27,2022));

        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        for(InventoryItem item : items){
                System.out.println(item.getPrice());
        }
    }
}
