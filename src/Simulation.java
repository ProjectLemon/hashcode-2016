import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * File: Simulation.java
 * Author: Fredrik Johansson
 * Date: 2016-02-11
 */

public class Simulation {

    public static void main(String[] args) {
        String data_file_name;
        if (args.length == 0) {
            data_file_name = "busy_day.in";
        } else {
            data_file_name = args[0];
        }

        SimulationParameters parameters = new SimulationParameters();
        IOHelper.parseFile(Paths.get("./data/"+data_file_name), parameters);


        int totTime = parameters.getTotalSimulationTime();

        Grid grid = new Grid(parameters.getNrOfRows(), parameters.getNrOfCols());

        Map<Position, Warehouse> warehouses = parameters.getWarehouses();
        List<Order> orders = parameters.getOrders();


        Warehouse minWarehouse = (Warehouse) parameters.getWarehouses().values().toArray()[0];
        for (Order order : orders) {
            double minDistance = distance(minWarehouse.getPosition(), order.getPosition());

            Iterator it = warehouses.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Warehouse warehouse = (Warehouse) pair.getValue();

                double distance = distance(warehouse.getPosition(), order.getPosition());
                if (distance < minDistance) {
                    minWarehouse = warehouse;
                    minDistance = distance;
                }

                warehouse.addOrder(order);
                grid.addWarehouse(warehouse, (Position) pair.getKey());
            }
            grid.addOrder(order, order.getPosition());
        }

        int nrOfDrones = parameters.getNrOfDrones();
        List<Drone> drones = new ArrayList<>(nrOfDrones);
        Iterator it = warehouses.entrySet().iterator();
        // Distribute drones to warehouses
        while (nrOfDrones > 0) {
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Warehouse warehouse = (Warehouse) pair.getValue();
                Position pos = (Position) pair.getKey();

                drones.add(new Drone(pos));
                nrOfDrones--;
            }
        }

        // Calculate paths
        it = warehouses.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Warehouse warehouse = (Warehouse) pair.getValue();
            Position pos = (Position) pair.getKey();




            Order outestOrder = warehouse.getOrders().get(0);
            double outestDistance = distance(outestOrder.getPosition(), pos);
            for (Order order : orders) {
                double distance = distance(order.getPosition(), pos);
                if (distance > outestDistance) {
                    outestDistance = distance;
                    outestOrder = order;
                }
            }




        }

        // Main loop
        for (int time = 0; time < totTime; time++) {

        }
    }


    public static double distance(Position pos1, Position pos2) {
        return Math.sqrt(Math.abs(pos1.getY() + pos2.getY()) + Math.abs(pos1.getX() + pos2.getX()));
    }

}
