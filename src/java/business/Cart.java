package business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart implements Serializable {

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        int productID = item.getProduct().getProductID();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductID() == productID) {
                lineItem.setQuantity(lineItem.getQuantity() + quantity);
                  
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        int productID = item.getProduct().getProductID();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductID() == productID) {
                items.remove(i);
                return;
            }
        }
    }
    


  
}
