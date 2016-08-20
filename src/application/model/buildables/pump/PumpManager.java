package application.model.buildables.pump;

import java.util.List;

import application.model.services.Fuel;

public interface PumpManager {
    
    /**
     * Gets the pump of a specific index.
     * @param Integer index of the pump.
     * @return Object of pump's type.
     */
    Pump getPump(final int i);
    
    /**
     * Gets the pump with a specific name.
     * @param String name of the pump.
     * @return Object of pump's type.
     */
    Pump getPumpByName(final String name);
    
    /**
     * Gets every pump in the list.
     * @return List of pump's type.
     */
    List<Pump> getAllPumps();
    
    /**
     * Adds a pump of an area with certain caracteristics.
     * @param Main attributes: name, type and speed.
     * @param Extended attributes from BuildableImpl.
     */
    void addPump(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final String name, final Fuel type, final int speed);
    
    /**
     * Removes a pump from the area.
     * @param Object of pump's type.
     */
    void removePump(final Pump pump);
    
    /**
     * Removes every pump from the area.
     */
    void removeAllPumps();	
}
