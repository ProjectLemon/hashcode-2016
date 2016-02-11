import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class Warehouse {
    private final Position position;
    private HashMap<Integer, Integer> productCount = new HashMap<>();

    public Warehouse(Position pos, HashMap<Integer, Integer> count) {
        this.position = pos;
        this.productCount = count;
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
}
