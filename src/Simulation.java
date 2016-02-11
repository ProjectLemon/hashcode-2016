/**
 * File: Simulation.java
 * Author: Fredrik Johansson
 * Date: 2016-02-11
 */

public class Simulation {

    public static void main(String[] args) {

        SimulationParameters parameters = new SimulationParameters();
        int totTime = parameters.getTotalSimulationTime();

        Grid grid = new Grid(parameters.getNrOfRows(), parameters.getNrOfCols());
        parameters.getWarehouses().forEach((pos, warehouse) -> {
            grid.addWarehouse(warehouse, pos);
        });
        parameters.getOrders().forEach((order) -> {
            
            grid.addOrder(order, order.getPosition());
        });


        // Main loop
        for (int time = 0; time < totTime; time++) {

        }


    }

}
