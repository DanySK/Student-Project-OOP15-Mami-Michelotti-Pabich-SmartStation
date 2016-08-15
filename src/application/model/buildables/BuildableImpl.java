package application.model.buildables;

public abstract class BuildableImpl implements Buildable{
	
    private int maxDurability;
    private int actualDurability;
    private int cost;
    private int repairCost;
	
    public BuildableImpl(final int maxDurability, final int actualDurability, final int cost, final int repairCost) {
    	this.maxDurability = maxDurability;
    	this.actualDurability = maxDurability;
    	this.cost = cost;
    	this.repairCost = repairCost;
    }
    
    @Override
    public int getCost() {
    	return this.cost;
    }
    
    @Override
    public void setCost(final int cost) {
    	this.cost = cost;		
    }
    
    @Override
    public int getDurability() {
    	return this.actualDurability;
    }
    
    public int getMaxDurability() {
        return this.maxDurability;
    }
    
    @Override
    public void setMaxDurability(final int durability) {
    	this.maxDurability = durability;	
    }
    
    @Override
    public int getRepairCost() {
    	return repairCost;
    }
    
    @Override
    public void setRepairCost(final int repairCost) {
    	this.repairCost = repairCost;	
    }
    
    @Override
    public void repair(final int percentage) {		
    	this.actualDurability += percentage;		
    }
}
