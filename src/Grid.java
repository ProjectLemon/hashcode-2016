import java.util.HashMap;
import java.util.Map;

/**
 * File: Grid.java
 * Author: Fredrik Johansson
 * Date: 2016-02-11
 */

public class Grid {

    private Map<Position, Object> grid = new HashMap<>();
    private int rows;
    private int colums;

    public Grid(int rows, int colums) {
        this.rows = rows;
        this.colums = colums;
    }

    public void addOrder(Order order, Position pos) {
        grid.put(pos, order);
    }

    public void addWarehouse(Warehouse warehouse, Position pos) {
        grid.put(pos, warehouse);
    }

    public Object getObjectOnPosition(Position pos) {
        return grid.get(pos);
    }
}
