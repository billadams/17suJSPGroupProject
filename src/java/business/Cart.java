package business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public List<LineItem> getItems() {
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
    
    public void updateItem(LineItem item) {
        int productID = item.getProduct().getProductID();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductID() == productID) {
                lineItem.setQuantity(quantity);
                  
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
    
    public String getCartTotalFormatted() {
        
        double total = 0;
        
        for (LineItem item : items) {
            
            total += item.getTotal();
            
        }
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(total);

    }
}
