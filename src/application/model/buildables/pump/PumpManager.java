package application.model.buildables.pump;

import java.util.List;

import application.model.services.Fuel;

public interface PumpManager {
	
    Pump getPump(final int i);
    
    Pump getPumpByName(final String name);
    	
    List<Pump> getAllPumps();
    
    void addPump(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final String name, final Fuel type, final int speed);
    	
    void removePump(final Pump pump);
    	
    void removeAllPumps();	
}
