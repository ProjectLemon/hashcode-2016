import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class Warehouse {
    private final Position position;
    private HashMap<Integer, Integer> productCount = new HashMap<>();
    private List<Order> orders = new ArrayList<>();
    private int ID;

    public Warehouse(Position pos, HashMap<Integer, Integer> count) {
        this.position = pos;
        this.productCount = count;
    }

    public Position getPosition() {
        return position;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int productCount(int productType) {
        return productCount.get(productType);
    }

    public int fetchProducts(int type, int count) throws IllegalArgumentException {
        if ( count < productCount.get(type) ) {
            throw new IllegalArgumentException("Insufficient amount");
        }
        int amount = productCount.get(type);
        productCount.put( type, (amount-count) );
        return amount;
    }

    public void putProducts(int type, int count) {
        if (productCount.containsKey(type)) {
            productCount.put( type, productCount.get(type)+count );
        } else {
            productCount.put(type, count);
        }
    }

    public boolean isProductInWarehouse(Integer product) {
        boolean found = true;
        //return if(found product)
        return found;
    }
}
