import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class Order {
    private final Position position;
    private int orderSize = 0;
    private List<Integer> productTypes = new ArrayList<>();
    private Warehouse warehouse;

    public Order(Position pos, int size, List<Integer> types) {
        this.position = pos;
        this.orderSize = size;
        this.productTypes = types;
    }

    public void addWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Position getPosition() {
        return position;
    }
    //TODO: getters
    //TODO: How many of each productType?
}
