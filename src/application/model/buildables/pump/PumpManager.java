package application.model.buildables.pump;

import java.util.List;


public interface PumpManager {
	
    Pump getPump(final int i);
    
    Pump getPumpByName(final String name);
    	
    List<Pump> getAllPumps();
    
    void addPump(final Pump pump);
    	
    void removePump(final Pump pump);
    	
    void removeAllPumps();	
}
