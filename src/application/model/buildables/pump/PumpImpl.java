package application.model.buildables.pump;

import application.model.buildables.BuildableImpl;
import application.model.services.Fuel;

public class PumpImpl extends BuildableImpl implements Pump{
	
    private String name;
    private Fuel type;
    private int speed; 
    
    public PumpImpl(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final String name, final Fuel type, final int speed){
	super(maxDurability, actualDurability, cost, repairCost);
	this.name = name;
        this.type = type;
        this.speed = speed ;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;        
    }
    
    @Override
    public Fuel getType() {
	return this.type;
    }

    @Override
    public void setType(final Fuel type) {
	this.type = type; 
    }

    @Override
    public int getSpeed() {
	return this.speed;
    }

    @Override
    public void setSpeed(final int speed) {
	this.speed = speed; 
    }
}
