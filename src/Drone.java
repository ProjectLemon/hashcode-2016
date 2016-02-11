import java.util.HashMap;
import java.util.Stack;

/**
 * File: Drone.java
 * Author: Fredrik Johansson
 * Date: 2016-02-11
 */

public class Drone {
    int ID;
    int timestep;
    int maxWeight = 0;
    int currentWeight = 0;
    double x;
    double y;
    Stack history;

    public Drone(double x, double y, int maxWeight, int ID;) {
        this.ID = ID;
        this.maxWeight = maxWeight;
    }

    public move( ,int timestep){

    }

    public addMoventHistory( ){
        this.timestep
        // hämta villket tidssteg
    }

    public int weightLeft(){
        return (maxWeight - currentWeight);
    }

    public boolean addWeight(int added){

        if((currentWeight + added) > maxWeight){
            return false;
        }else{
            currentWeight = (currentWeight + added);
            return true;
        }
    }
    public Load(int ){

}   }






● the ID of the drone that the command is for
        ● the command tag ­ a single character, either ‘L’ (for load) or ‘U’ (for unload),
        ● the ID of the warehouse from which we load items / to which we unload items
        ● the ID of the product type
        ● the number of items of the product type to be loaded or unloaded ­ a positive integer