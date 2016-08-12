package application.model;

import application.model.buildables.area.AreaManager;
import application.model.buildables.pump.PumpManager;
import application.model.buildables.reserve.ReserveManager;
import application.model.moneyManager.MoneyManager;
import application.model.services.FuelManager;


public interface Station {	
      
    String getStationName();
    
    void setStationName(final String name);
    
    int getMaxAreas();
    
    void setMaxAreas(final int maxAreas);
    
    int getMaxPumps();
    
    void setMaxPumps(final int maxPumps);
    
    void open();
    	
    void close();
    	
    AreaManager getAreaManager();
    PumpManager getPumpManager();
    ReserveManager getReserveManager();
    FuelManager getFuelManager();
    MoneyManager getMoneyManager();
}
