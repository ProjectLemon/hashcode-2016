import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by linuslagerhjelm on 16-02-11.
 */
public class SimulationParameters {

    // === Grid info ===
    private int nrOfRows = 0;
    private int nrOfCols = 0;
    private int nrOfDrones = 0;
    private int totalSimulationTime = 0;
    private int maxLoadDrones = 0;

    // === Package info ===
    private int nrOfProductTypes = 0;
    private HashMap<Integer, Integer> productWeight = new HashMap<>();

    // === Warehouse info ===
    private int nrOfWarehouses = 0;
    private HashMap<Position, Warehouse> warehouses = new HashMap<>();

    // === Customer orders ===
    private int nrOfCustomerOrders = 0;
    private List<Order> orders = new LinkedList<>();


    // === SETTERS ===
    public void setProductWeight(HashMap<Integer, Integer> productWeight) {
        this.productWeight = productWeight;
    }

    public void setWarehouses(HashMap<Position, Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setNrOfRows(int nrOfRows) {
        this.nrOfRows = nrOfRows;
    }

    public void setNrOfCols(int nrOfCols) {
        this.nrOfCols = nrOfCols;
    }

    public void setNrOfDrones(int nrOfDrones) {
        this.nrOfDrones = nrOfDrones;
    }

    public void setTotalSimulationTime(int totalSimulationTime) {
        this.totalSimulationTime = totalSimulationTime;
    }

    public void setMaxLoadDrones(int maxLoadDrones) {
        this.maxLoadDrones = maxLoadDrones;
    }

    public void setNrOfProductTypes(int nrOfProductTypes) {
        this.nrOfProductTypes = nrOfProductTypes;
    }

    public void setNrOfWarehouses(int nrOfWarehouses) {
        this.nrOfWarehouses = nrOfWarehouses;
    }

    public void setNrOfCustomerOrders(int nrOfCustomerOrders) {
        this.nrOfCustomerOrders = nrOfCustomerOrders;
    }

    // === GETTERS ===
    public int getNrOfRows() {
        return nrOfRows;
    }

    public int getNrOfCols() {
        return nrOfCols;
    }

    public int getNrOfDrones() {
        return nrOfDrones;
    }

    public int getTotalSimulationTime() {
        return totalSimulationTime;
    }

    public int getMaxLoadDrones() {
        return maxLoadDrones;
    }

    public int getNrOfProductTypes() {
        return nrOfProductTypes;
    }

    public HashMap<Integer, Integer> getProductWeight() {
        return productWeight;
    }

    public int getNrOfWarehouses() {
        return nrOfWarehouses;
    }

    public HashMap<Position, Warehouse> getWarehouses() {
        return warehouses;
    }

    public int getNrOfCustomerOrders() {
        return nrOfCustomerOrders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
