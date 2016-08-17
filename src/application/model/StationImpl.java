package application.model;

import application.model.area.AreaManager;
import application.model.area.AreaManagerImpl;
import application.model.buildables.pump.PumpManager;
import application.model.buildables.pump.PumpManagerImpl;
import application.model.buildables.reserve.ReserveManager;
import application.model.buildables.reserve.ReserveManagerImpl;
import application.model.moneyManager.MoneyManager;
import application.model.moneyManager.MoneyManagerImpl;
import application.model.services.FuelManager;
import application.model.services.FuelManagerImpl;


public class StationImpl implements Station{	
    
    private final AreaManager areaManager;
    private final PumpManager pumpManager;
    private final ReserveManager reserveManager;
    private final MoneyManager moneyManager;
    private final FuelManager fuelManager;
    
    private boolean isOpen;
    private String name;
    private String address;
    private int maxAreas;
    private int maxPumps;
	
    public StationImpl() {      
        this.areaManager = new AreaManagerImpl();
        this.pumpManager = new PumpManagerImpl();
        this.reserveManager = new ReserveManagerImpl();
        this.moneyManager = new MoneyManagerImpl();
        this.fuelManager = new FuelManagerImpl();
    }
    
    @Override
    public String getStationName() {
        return this.name;
    }

    @Override
    public void setStationName(final String name) {
        this.name = name;      
    }
    
    @Override
    public int getMaxAreas() {
        return this.maxAreas;
    }
    
    @Override
    public void setMaxAreas(final int maxAreas) {
        this.maxAreas = maxAreas;      
    }
    
    @Override
    public int getMaxPumps() {
        return this.maxPumps;
    }
    
    @Override
    public void setMaxPumps(final int maxPumps) {
        this.maxPumps = maxPumps;       
    }
    
    @Override
    public void open() {
    	this.isOpen = true;		
    }
    
    @Override
    public void close() {
    	this.isOpen = false;		
    }
    	
    @Override
    public AreaManager getAreaManager() {
    	return this.areaManager;
    }
	
    @Override
    public PumpManager getPumpManager() {
        return this.pumpManager;
    }
    
    @Override
    public ReserveManager getReserveManager() {
        return this.reserveManager;
    }
    
    @Override
    public MoneyManager getMoneyManager() {
        return this.moneyManager;
    }

    @Override
    public FuelManager getFuelManager() {
        return this.fuelManager;
    }
}
