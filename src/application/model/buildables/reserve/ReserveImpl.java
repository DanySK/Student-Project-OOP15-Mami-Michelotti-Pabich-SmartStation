package application.model.buildables.reserve;

import application.model.buildables.BuildableImpl;
import application.model.services.Fuel;

public class ReserveImpl extends BuildableImpl implements Reserve{
	
    private Fuel type;
    private int capacity;
    private int actualCapacity;
    
    public ReserveImpl(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final Fuel type, final int capacity, final int durability) {
    	super(maxDurability, actualDurability, cost, repairCost);
    	this.type = type;
        this.capacity = capacity;
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
    public int getCapacity() {
	return this.capacity;
    }

    @Override
    public void setCapacity(final int capacity) {
	this.capacity = capacity;
    }

    @Override
    public int getRemaining() {
    	return this.actualCapacity;
    }

    @Override
    public void setRemaining(final int remaining) {
        this.actualCapacity = remaining;
    }

    @Override
    public void refill(final int refill) {
	this.actualCapacity += refill;
    }
}
