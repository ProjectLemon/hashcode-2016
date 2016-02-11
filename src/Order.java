import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class Order {
    private final Position position;
    private int orderSize = 0;
    private List<Integer> productTypes = new ArrayList<>();
    private Warehouse closestWarehouse;
    private Integer weight = 0;

    public Order(Position pos, int size, List<Integer> types, Integer weight) {
        this.weight = weight;
        this.position = pos;
        this.orderSize = size;
        this.productTypes = types;
    }

    public void addWarehouse(Warehouse warehouse) {
        this.closestWarehouse = warehouse;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isProductInClosestWarehouse(Integer product) {
        boolean found = closestWarehouse.isProductInWarehouse(product);
        return found;
    }

    //TODO: getters
    //TODO: How many of each productType?
}
