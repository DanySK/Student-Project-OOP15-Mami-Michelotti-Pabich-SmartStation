package application.model.buildables.pump;

import java.util.List;


public interface PumpManager {
	
	Pump getPump(int i);
	
	List<Pump> getAllPumps();
	
	void addPump(Pump pump);
	
	void removePump(Pump pump);
	
	void removeAllPumps ();	
}
