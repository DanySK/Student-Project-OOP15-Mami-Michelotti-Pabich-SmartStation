package application.model.buildables.pump;

import application.model.buildables.Buildable;
import application.model.services.Fuel;

/**
 * Interface containing all the logic of a Pump extended by Buildable.
 * @author Alessandro Mami
 *
 */
public interface Pump extends Buildable{
    
    /**
     * Gets the name of a pump.
     * @return String of pump's name.
     */
    String getName();
    
    /**
     * Gives the name to a pump.
     * @param String of pump's name.
     */
    void setName(String name);

    /**
     * Gets the fuel type of a pump.
     * @return Object of fuel's type.
     */
    Fuel getType();
    
    /**
     * Sets the fuel's type of a pump.
     * @param Object of fuel's type.
     */
    void setType(Fuel type);
    
    /**
     * Gets the speed a pump.
     * @return Integer of pumps's speed.
     */
    int getSpeed();
    
    /**
     * Sets the speed a pump.
     * @param Integer of pumps's speed.
     */
    void setSpeed(int speed);
}
